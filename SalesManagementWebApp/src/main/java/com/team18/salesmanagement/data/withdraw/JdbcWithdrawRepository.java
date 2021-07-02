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
        Map<String, Object> params = new HashMap<>();
        
        params.put("param_customer_id", withdraw.getCustomerId());
        params.put("param_withdraw_amount", withdraw.getWithdrawAmount());
        params.put("param_balance_before_withdraw",
                withdraw.getBalanceBeforeWithdraw());
        params.put("param_balance_after_withdraw",
                withdraw.getBalanceAfterWithdraw());
        params.put("param_withdraw_date",
                withdraw.getWithdrawDate());
        
        simpleJdbcCall.withProcedureName("insert_withdraw")
                .execute(params);
    }
}
