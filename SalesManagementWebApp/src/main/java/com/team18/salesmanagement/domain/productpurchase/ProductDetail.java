// File: ProductDetail.java
// Class ProductDetail represent a ProductDetail in Order
// Author: 1760169 - Le Anh Tai
// Email: leanhtai01@gmail.com
// GitHub: https://github.com/leanhtai01
package com.team18.salesmanagement.domain.productpurchase;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductDetail implements Serializable {
    private Integer id;
    private String name;
    private Double weight;
    private BigDecimal price;
    private Integer quantity;
    private Integer productDiscountId;
    private BigDecimal discountValue;
    private String discountUnit;

    public ProductDetail() {
    }

    public ProductDetail(Integer id, String name, Double weight, BigDecimal price,
            Integer quantity, Integer productDiscountId,
            BigDecimal discountValue, String discountUnit) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.quantity = quantity;
        this.productDiscountId = productDiscountId;
        this.discountValue = discountValue;
        this.discountUnit = discountUnit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getProductDiscountId() {
        return productDiscountId;
    }

    public void setProductDiscountId(Integer productDiscountId) {
        this.productDiscountId = productDiscountId;
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
