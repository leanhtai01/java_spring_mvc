// File: JdbcOrderRepository.java
// Data access operations for Order using JDBC
// Author: 1760169 - Le Anh Tai
// Email: leanhtai01@gmail.com
// GitHub: https://github.com/leanhtai01
package com.team18.salesmanagement.data.order;

import com.team18.salesmanagement.domain.order.Order;
import java.util.HashMap;
import java.util.Map;
import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcOrderRepository implements IOrderRepository {
    
    private final JdbcOperations jdbcOperations;
    private final SimpleJdbcCall simpleJdbcCall;

    @Autowired
    public JdbcOrderRepository(JdbcOperations jdbcOperations,
            SimpleJdbcCall simpleJdbcCall) {
        this.jdbcOperations = jdbcOperations;
        this.simpleJdbcCall = simpleJdbcCall;
    }

    // insert an Order
    @Override
    public Integer insert(Order order) {
        Map<String, Object> params = new HashMap<>();
        Integer orderId = -1;
        
        params.put("order_id", orderId);
        params.put("param_customer_id", order.getCustomerId());
        params.put("param_order_date", Date.valueOf(order.getOrderDate()));
        params.put("param_discount_value", order.getDiscountValue());
        params.put("param_discount_unit", order.getDiscountUnit());
        
        Map<String, Object> result = simpleJdbcCall
                .withProcedureName("insert_order")
                .execute(params);
        
        return (Integer) result.get("order_id");
    }
    
}
