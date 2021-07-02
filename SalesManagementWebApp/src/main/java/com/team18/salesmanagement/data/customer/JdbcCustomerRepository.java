// File: JdbcCustomerRepository.java
// Data access operations for Customer using JDBC
// Author: 1760169 - Le Anh Tai
// Email: leanhtai01@gmail.com
// GitHub: https://github.com/leanhtai01
package com.team18.salesmanagement.data.customer;

import com.team18.salesmanagement.domain.customer.Customer;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcCustomerRepository implements ICustomerRepository {

    private final JdbcOperations jdbcOperations;
    private final SimpleJdbcCall simpleJdbcCall;

    @Autowired
    public JdbcCustomerRepository(JdbcOperations jdbcOperations,
            SimpleJdbcCall simpleJdbcCall) {
        this.jdbcOperations = jdbcOperations;
        this.simpleJdbcCall = simpleJdbcCall;
    }

    // get Customer's information
    @Override
    public List<Customer> getCustomerInfo(String phoneNumber) {
        Map<String, Object> inParams = new HashMap<>();

        if (phoneNumber.isEmpty()) {
            inParams.put("param_phone_number", null);
        }
        else {
            inParams.put("param_phone_number", phoneNumber);
        }

        Map<String, Object> result = simpleJdbcCall
                .withProcedureName("get_customer_info")
                .returningResultSet("customers", (rs, rowNum) -> {
                    return new Customer(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("phone_number"),
                            rs.getString("email"),
                            rs.getBigDecimal("balance"),
                            rs.getInt("membership_type_id"),
                            rs.getString("membership_type")
                    );
                })
                .execute(inParams);
        return (List<Customer>) result.get("customers");
    } // end method getCustomerList
    
    // delete Customer by id
    @Override
    public void deleteCustomer(int id) {
        final String DELETE_CUSTOMER = "DELETE FROM customers"
                + " WHERE id = ?";
        
        jdbcOperations.update(DELETE_CUSTOMER, id);
    }
    
    // get Customer by id
    @Override
    public Customer getCustomer(int id) {
        final String GET_CUSTOMER = "SELECT c.id, c.name, c.phone_number,"
                + " c.email, c.balance, c.membership_type_id,"
                + " (SELECT mst.membership_type"
                + " FROM membership_types mst"
                + " WHERE mst.id = c.membership_type_id) AS membership_type"
                + " FROM customers c"
                + " WHERE c.id = ?;";
        return jdbcOperations.queryForObject(GET_CUSTOMER,
                (rs, rowNum) -> {
                    return new Customer(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("phone_number"),
                            rs.getString("email"),
                            rs.getBigDecimal("balance"),
                            rs.getInt("membership_type_id"),
                            rs.getString("membership_type")
                    );
                }, id);
    }
    
    // insert a Customer
    @Override
    public Integer insert(Customer customer) {
        Map<String, Object> params = new HashMap<>();
        int error_code = 0;
        Integer cust_id = -1;
        
        params.put("cust_name", customer.getName());
        params.put("cust_phone_number", customer.getPhoneNumber());
        params.put("cust_email", customer.getEmail());
        params.put("cust_balance", customer.getBalance());
        params.put("cust_membership_type_id", customer.getMembershipTypeId());
        params.put("cust_id", cust_id);
        params.put("error_code", error_code);
        
        Map<String, Object> result = simpleJdbcCall
                .withProcedureName("insert_customer")
                .execute(params);
        error_code = (int) result.get("error_code");
        
        if (error_code == 1) {
            throw new DuplicatePhoneNumberException();
        }
        else if (error_code == 2) {
            throw new DuplicateEmailException();
        }
        
        return (Integer) result.get("cust_id");
    }
    
    // update a Customer
    @Override
    public void update(Customer customer) {
        Map<String, Object> params = new HashMap<>();
        int error_code = 0;
        
        params.put("cust_id", customer.getId());
        params.put("cust_name", customer.getName());
        params.put("cust_phone_number", customer.getPhoneNumber());
        params.put("cust_email", customer.getEmail());
        params.put("cust_balance", customer.getBalance());
        params.put("cust_membership_type_id", customer.getMembershipTypeId());
        params.put("error_code", error_code);
        
        Map<String, Object> result = simpleJdbcCall
                .withProcedureName("update_customer")
                .execute(params);
        error_code = (int) result.get("error_code");
        
        switch (error_code) {
            case 1:
                throw new DuplicatePhoneNumberException();
            case 2:
                throw new DuplicateEmailException();
            case 3:
                throw new NotExistsCustomerException();
            default:
                break;
        }
    }
    
    // get Customer id given phone number
    @Override
    public Integer getId(String phoneNumber) {
        Map<String, Object> params = new HashMap<>();
        int error_code = 0;
        Integer id = -1;
        
        params.put("cust_phone_number", phoneNumber);
        params.put("cust_id", id);
        params.put("error_code", error_code);
        
        Map<String, Object> result = simpleJdbcCall
                .withProcedureName("get_customer_id")
                .execute(params);
        error_code = (int) result.get("error_code");
        
        if (error_code == 1) {
            throw new CustomerNotFoundException();
        }
        
        return (Integer) result.get("cust_id");
    }
    
    // get Customer by given phone number
    @Override
    public Customer getCustomer(String phoneNumber) {
        Map<String, Object> inParams = new HashMap<>();
        int error_code = -1;

        inParams.put("cust_phone_number", phoneNumber);
        inParams.put("error_code", error_code);

        Map<String, Object> result = simpleJdbcCall
                .withProcedureName("get_customer")
                .returningResultSet("customers", (rs, rowNum) -> {
                    return new Customer(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("phone_number"),
                            rs.getString("email"),
                            rs.getBigDecimal("balance"),
                            rs.getInt("membership_type_id"),
                            rs.getString("membership_type")
                    );
                })
                .execute(inParams);
        error_code = (int) result.get("error_code");
        
        if (error_code == 1) {
            throw new CustomerNotFoundException();
        }
        
        return ((List<Customer>) result.get("customers")).get(0);
    }
    
    // update Customer's balance
    @Override
    public void updateBalance(Integer id, BigDecimal balance) {
        final String UPDATE_CUSTOMER_BALANCE = "UPDATE customers "
                + "SET balance = ? "
                + "WHERE id = ?;";
        
        jdbcOperations.update(UPDATE_CUSTOMER_BALANCE, balance, id);
    }
} // end class JdbcCustomerRepository
