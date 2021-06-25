// File: OrderDetail.java
// Class OrderDetail represent an Order Detail
// Author: 1760169 - Le Anh Tai
// Email: leanhtai01@gmail.com
// GitHub: https://github.com/leanhtai01
package com.team18.salesmanagement.domain.orderdetail;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderDetail implements Serializable {
    private int orderId;
    private int productId;
    private int quantity;
    private BigDecimal discountValue;
    private String discountUnit;

    public OrderDetail() {
    }

    public OrderDetail(int orderId, int productId, int quantity,
            BigDecimal discountValue, String discountUnit) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.discountValue = discountValue;
        this.discountUnit = discountUnit;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
