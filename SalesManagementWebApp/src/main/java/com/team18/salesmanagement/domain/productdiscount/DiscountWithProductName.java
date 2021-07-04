/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team18.salesmanagement.domain.productdiscount;

import java.time.LocalDate;

/**
 *
 * @author minkes
 */
public class DiscountWithProductName {
    private Integer id;
    private Integer product_id;
    private String product_name;
    private Double product_weight;
    private Float discount_value;
    private String discount_unit;
    private LocalDate valid_from;
    private LocalDate valid_until;

    public DiscountWithProductName() {
    }

    public DiscountWithProductName(Integer id, Integer product_id, String product_name, Double product_weight, Float discount_value, String discount_unit, LocalDate valid_from, LocalDate valid_until) {
        this.id = id;
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_weight = product_weight;
        this.discount_value = discount_value;
        this.discount_unit = discount_unit;
        this.valid_from = valid_from;
        this.valid_until = valid_until;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Double getProduct_weight() {
        return product_weight;
    }

    public void setProduct_weight(Double product_weight) {
        this.product_weight = product_weight;
    }

    public Float getDiscount_value() {
        return discount_value;
    }

    public void setDiscount_value(Float discount_value) {
        this.discount_value = discount_value;
    }

    public String getDiscount_unit() {
        return discount_unit;
    }

    public void setDiscount_unit(String discount_unit) {
        this.discount_unit = discount_unit;
    }

    public LocalDate getValid_from() {
        return valid_from;
    }

    public void setValid_from(LocalDate valid_from) {
        this.valid_from = valid_from;
    }

    public LocalDate getValid_until() {
        return valid_until;
    }

    public void setValid_until(LocalDate valid_until) {
        this.valid_until = valid_until;
    }

    
}
