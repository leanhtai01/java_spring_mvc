// File: Order.java
// Class Order represent an Order
// Author: 1760169 - Le Anh Tai
// Email: leanhtai01@gmail.com
// GitHub: https://github.com/leanhtai01
package com.team18.salesmanagement.domain.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Order implements Serializable {
    private int id;
    private int customerId;
    private LocalDate orderDate;
    private BigDecimal discountValue;
    private String discountUnit;

    public Order() {
    }

    public Order(int id, int customerId, LocalDate orderDate,
            BigDecimal discountValue, String discountUnit) {
        this.id = id;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.discountValue = discountValue;
        this.discountUnit = discountUnit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(BigDecimal discountValue) {
        this.discountValue = discountValue;
    }

    public String getDiscountUnit() {
        return discountUnit;
    }

    public void setDiscountUnit(String discountUnit) {
        this.discountUnit = discountUnit;
    }
}
