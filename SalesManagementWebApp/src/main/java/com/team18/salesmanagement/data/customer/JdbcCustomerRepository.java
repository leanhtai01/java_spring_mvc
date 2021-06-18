// File: JdbcCustomerRepository.java
// Data access operations for Customer using JDBC
// Author: 1760169 - Le Anh Tai
// Email: leanhtai01@gmail.com
// GitHub: https://github.com/leanhtai01
package com.team18.salesmanagement.data.customer;

import com.team18.salesmanagement.domain.customer.Customer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcCustomerRepository implements ICustomerRepository {

    private final JdbcOperations jdbcOperations;

    @Autowired
    public JdbcCustomerRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    // get Customer list
    @Override
    public List<Customer> getCustomerList() {
        final String SELECT_ALL_CUSTOMERS = "SELECT * FROM customers;";

        return jdbcOperations.query(SELECT_ALL_CUSTOMERS,
                (rs, rowNum) -> {
                    return new Customer(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("phone_number"),
                            rs.getString("email"),
                            rs.getBigDecimal("balance"),
                            rs.getInt("membership_type_id")
                    );
                });
    } // end method getCustomerList
} // end class JdbcCustomerRepository
