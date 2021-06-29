/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team18.salesmanagement.domain.invoice;

import com.team18.salesmanagement.domain.product.Product;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author HuuDepTrai
 */
public class OrderDetail implements Serializable{

    private Integer order_id;
    private Integer product_id;
    private Integer quantity ;
    private Double discount_value;
    private DiscountUnit discount_unit;
    private Product product;
    
    private String discount_unit_display;
    private Double amount;
    private Double priceOrigin;
    
    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getDiscount_unit_display() {
        return discount_unit_display;
    }

    public void setDiscount_unit_display(String discount_unit_display) {
        this.discount_unit_display = discount_unit_display;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }


    public Double getPriceOrigin() {
        return priceOrigin;
    }

    public void setPriceOrigin(Double priceOrigin) {
        this.priceOrigin = priceOrigin;
    }
    
    public OrderDetail() {
    }
    
    public OrderDetail(Integer order_id, Integer product_id, Integer quantity, Double discount_value, 
            DiscountUnit discount_unit, Integer id, String name, Double weight, Double price) {
        this.order_id = order_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.discount_value = discount_value;
        this.discount_unit = discount_unit;
        this.product =  new Product(id, name, weight, price);
        // caculate price display
        this.priceOrigin = (Double) (price * quantity);
        if (discount_unit.equals(discount_unit.FLAT_CURRENCY)) {
            this.discount_unit_display = "VND";
            this.amount = this.priceOrigin - discount_value;
        } else {
            this.discount_unit_display = "%";
            this.amount = this.priceOrigin - (this.priceOrigin * (discount_value/100.0d));
        }
    }
}
