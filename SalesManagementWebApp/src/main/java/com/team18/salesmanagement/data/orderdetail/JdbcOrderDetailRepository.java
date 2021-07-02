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
        final String INSERT_ORDER_DETAIL =
                "INSERT INTO order_details(order_id, product_id, quantity, "
                                        + "discount_value, discount_unit) "
              + "VALUES (?, ?, ?, ?, ?);";
        
        jdbcOperations.update(INSERT_ORDER_DETAIL,
                orderDetail.getOrderId(),
                orderDetail.getProductId(),
                orderDetail.getQuantity(),
                orderDetail.getDiscountValue(),
                orderDetail.getDiscountUnit()
        );
    }
}
