/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team18.salesmanagement.data.invoice;

import com.team18.salesmanagement.data.customer.ICustomerRepository;
import com.team18.salesmanagement.data.product.IProductRepository;
import com.team18.salesmanagement.domain.invoice.DiscountUnit;
import com.team18.salesmanagement.domain.invoice.Invoice;
import com.team18.salesmanagement.domain.invoice.OrderDetail;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HuuDepTrai
 */
@Repository
public class InvoiceImp implements InvoiceInterface{
    
    @Autowired
    ICustomerRepository customerRepository;
    private final JdbcOperations jdbcOperations;
    
    @Autowired
    public InvoiceImp(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }
    
    @Override
    public Invoice getInvoiceById(Integer order_id) {
        Invoice result;
        String SQL = "select * from orders where id="+ order_id;
        result = jdbcOperations.queryForObject(SQL, (rs, rowNum) -> {
            DiscountUnit enumUnit = DiscountUnit.valueOf(rs.getString("discount_unit"));
                    return new Invoice(
                            rs.getInt("id"),
                            rs.getInt("customer_id"),
                            rs.getDate("order_date"),
                            rs.getDouble("discount_value"),
                            enumUnit
                    );
                });
        result.setOrderDetail(getOrderDetailByOrderId(order_id));
        // caculate price
        Double subTotal = result.getOrderDetail().stream().reduce(0.0, (subtotal, orderDetail) -> subtotal + orderDetail.getAmount(), Double::sum);
        System.out.println(result.getDiscount_value());
        System.out.println(subTotal - result.getDiscount_value());
        if (result.getDiscount_unit().equals(result.getDiscount_unit().FLAT_CURRENCY)) {
            result.setDiscount_unit_display("VND");
            result.setPriceDiscount(result.getDiscount_value());
        } else {
            result.setDiscount_unit_display("%");
            result.setPriceDiscount(subTotal * (result.getDiscount_value() / 100.0d));
        }
        result.setAmount(subTotal - result.getPriceDiscount());
        result.setSubTotal(subTotal);
        
        result.setCustomer(customerRepository.getCustomer(result.getCustomer_id()));
        return result;
    }
    
    private List<OrderDetail> getOrderDetailByOrderId(Integer order_id) {
        List<OrderDetail> rs;
        String SQL = "SELECT order_details.order_id,order_details.product_id,order_details.quantity,"
                + "order_details.discount_value,order_details.discount_unit,products.id,products.name,"
                + "products.weight,products.price  FROM `order_details`" +
                "INNER JOIN products ON products.id = order_details.product_id WHERE order_id="+ order_id;
        rs = jdbcOperations.query(SQL, new RowMapper<OrderDetail>() {
            @Override
            public OrderDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
                DiscountUnit enumUnit = DiscountUnit.valueOf(rs.getString("discount_unit"));
                return new OrderDetail(
                        rs.getInt("order_id"),
                        rs.getInt("product_id"),
                        rs.getInt("quantity"),
                        rs.getDouble("discount_value"),
                        enumUnit,
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("weight"),
                        rs.getDouble("price")
                );
            }
        });
        return rs;
    }

}
