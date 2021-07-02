// File: JdbcWithdrawRepository.java
// Data access operations for Withdraw using JDBC
// Author: 1760169 - Le Anh Tai
// Email: leanhtai01@gmail.com
// GitHub: https://github.com/leanhtai01
package com.team18.salesmanagement.data.withdraw;

import com.team18.salesmanagement.domain.withdraw.Withdraw;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcWithdrawRepository implements IWithdrawRepository {
    private final JdbcOperations jdbcOperations;
    private final SimpleJdbcCall simpleJdbcCall;

    @Autowired
    public JdbcWithdrawRepository(JdbcOperations jdbcOperations,
            SimpleJdbcCall simpleJdbcCall) {
        this.jdbcOperations = jdbcOperations;
        this.simpleJdbcCall = simpleJdbcCall;
    }
    
    // insert a Withdraw
    @Override
    public void insert(Withdraw withdraw) {
        final String INSERT_WITHDRAW =
                "INSERT INTO withdraws(customer_id, withdraw_amount, "
                                    + "balance_before_withdraw, "
                                    + "balance_after_withdraw, withdraw_date) "
              + "VALUES (?, ?, ?, ?, ?)";
        
        jdbcOperations.update(INSERT_WITHDRAW,
                withdraw.getCustomerId(),
                withdraw.getWithdrawAmount(),
                withdraw.getBalanceBeforeWithdraw(),
                withdraw.getBalanceAfterWithdraw(),
                withdraw.getWithdrawDate()
        );
    }
}
