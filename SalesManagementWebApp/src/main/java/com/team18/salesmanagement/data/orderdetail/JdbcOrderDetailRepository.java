// File: JdbcOrderDetailRepository.java
// Data access operation for Order Detail using JDBC
// Author: 1760169 - Le Anh Tai
// Email: leanhtai01@gmail.com
// GitHub: https://github.com/leanhtai01
package com.team18.salesmanagement.data.orderdetail;

import com.team18.salesmanagement.domain.orderdetail.OrderDetail;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcOrderDetailRepository implements IOrderDetailRepository {
    private final JdbcOperations jdbcOperations;
    private final SimpleJdbcCall simpleJdbcCall;

    @Autowired
    public JdbcOrderDetailRepository(JdbcOperations jdbcOperations,
            SimpleJdbcCall simpleJdbcCall) {
        this.jdbcOperations = jdbcOperations;
        this.simpleJdbcCall = simpleJdbcCall;
    }

    // insert an Order Detail
    @Override
    public void insert(OrderDetail orderDetail) {
        Map<String, Object> params = new HashMap<>();
        
        params.put("param_order_id", orderDetail.getOrderId());
        params.put("param_product_id", orderDetail.getProductId());
        params.put("param_quantity", orderDetail.getQuantity());
        params.put("param_discount_value", orderDetail.getDiscountValue());
        params.put("param_discount_unit", orderDetail.getDiscountUnit());
        
        simpleJdbcCall.withProcedureName("insert_order_detail")
                .execute(params);
    }
}
