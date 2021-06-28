/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team18.salesmanagement.domain.invoice;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author HuuDepTrai
 */
public class Invoice implements Serializable{

    private Integer id;
    private Integer customer_id;
    private Date order_date;
    private Double discount_value;
    private DiscountUnit discount_unit;
    private List<OrderDetail> orderDetail = new ArrayList<>();

    public Invoice(Integer id, Integer customer_id, Date order_date, Double discount_value, DiscountUnit discount_unit) {
        this.id = id;
        this.customer_id = customer_id;
        this.order_date = order_date;
        this.discount_value = discount_value;
        this.discount_unit = discount_unit;
    }

    public Invoice() {
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public Double getDiscount_value() {
        return discount_value;
    }

    public void setDiscount_value(Double discount_value) {
        this.discount_value = discount_value;
    }

    public DiscountUnit getDiscount_unit() {
        return discount_unit;
    }

    public void setDiscount_unit(DiscountUnit discount_unit) {
        this.discount_unit = discount_unit;
    }

    public List<OrderDetail> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(List<OrderDetail> orderDetail) {
        this.orderDetail = orderDetail;
    }
    
}
