// File: JdbcCustomerRepository.java
// Data access operations for Customer using JDBC
// Author: 1760169 - Le Anh Tai
// Email: leanhtai01@gmail.com
// GitHub: https://github.com/leanhtai01
package com.team18.salesmanagement.data.customer;

import com.team18.salesmanagement.domain.customer.Customer;
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

    // get Customer list
    @Override
    public List<Customer> getCustomerList() {
        Map<String, Object> inParams = new HashMap<>();
        
        inParams.put("param_phone_number", null);
        
        Map<String, Object> result = simpleJdbcCall
                .withProcedureName("get_customer_detail")
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
} // end class JdbcCustomerRepository
