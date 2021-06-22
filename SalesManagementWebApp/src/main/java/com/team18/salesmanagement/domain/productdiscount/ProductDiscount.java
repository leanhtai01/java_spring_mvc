/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team18.salesmanagement.domain.productdiscount;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author minkes
 */
public class ProductDiscount implements Serializable {

    private Integer id;
    private Integer product_id;
    private Float discount_value;
    private String discount_unit;
    private String valid_from;
    private String valid_until;

    public ProductDiscount() {
    }

    public ProductDiscount(Integer id, Integer product_id, Float discount_value, String discount_unit, String valid_from, String valid_until) {
        this.id = id;
        this.product_id = product_id;
        this.discount_value = discount_value;
        this.discount_unit = discount_unit;
        this.valid_from = valid_from;
        this.valid_until = valid_until;
    }

    public ProductDiscount(Integer product_id, Float discount_value, String discount_unit, String valid_from, String valid_until) {
        this.product_id = product_id;
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

    public String getValid_from() {
        return valid_from;
    }

    public void setValid_from(String valid_from) {
        this.valid_from = valid_from;
    }

    public String getValid_until() {
        return valid_until;
    }

    public void setValid_until(String valid_until) {
        this.valid_until = valid_until;
    }

}
