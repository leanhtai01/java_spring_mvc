/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team18.salesmanagement.data.saleshistory;

import com.team18.salesmanagement.domain.saleshistory.SalesHistory;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

/**
 *
 * @author minkes
 */
@Repository
public class JdbcSalesHistoryRepository implements ISalesHistoryRepository {
    private final JdbcOperations jdbcOperations;
    private final SimpleJdbcCall simpleJdbcCall;

    @Autowired
    public JdbcSalesHistoryRepository(JdbcOperations jdbcOperations,
            SimpleJdbcCall simpleJdbcCall) {
        this.jdbcOperations = jdbcOperations;
        this.simpleJdbcCall = simpleJdbcCall;
    }
    
    @Override
    public List<SalesHistory> getHistory(Date fromDate, Date toDate) {
        Map<String, Object> inParams = new HashMap<>();

        inParams.put("from_Date", fromDate);
        inParams.put("to_Date", toDate);
       
        Map<String, Object> result = simpleJdbcCall
                .withProcedureName("get_history")
                .returningResultSet("history", (rs, rowNum) -> {
                    return new SalesHistory(
                            rs.getInt("customer_id"),
                            rs.getInt("order_id"),
                            rs.getString("customer_name"),
                            rs.getBigDecimal("total_detail"),
                            rs.getDate("order_date").toLocalDate()
                    );
                })
                .execute(inParams);
        return (List<SalesHistory>) result.get("history");
    }
}
