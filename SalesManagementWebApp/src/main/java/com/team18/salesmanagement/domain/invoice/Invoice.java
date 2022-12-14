/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team18.salesmanagement.domain.invoice;

import com.team18.salesmanagement.domain.customer.Customer;
import com.team18.salesmanagement.domain.membershiptype.MembershipType;
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
    private Customer customer;
    private MembershipType membershipType;
    private List<OrderDetail> orderDetail = new ArrayList<>();
    
    private String discount_unit_display;
    private Double priceDiscount;
    private Double amount;
    private Double subTotal;
    private Double priceMemberDiscount;

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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getDiscount_unit_display() {
        return discount_unit_display;
    }

    public void setDiscount_unit_display(String discount_unit_display) {
        this.discount_unit_display = discount_unit_display;
    }

    public Double getPriceDiscount() {
        return priceDiscount;
    }

    public void setPriceDiscount(Double priceDiscount) {
        this.priceDiscount = priceDiscount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public MembershipType getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(MembershipType membershipType) {
        this.membershipType = membershipType;
    }

    public Double getPriceMemberDiscount() {
        return priceMemberDiscount;
    }

    public void setPriceMemberDiscount(Double priceMemberDiscount) {
        this.priceMemberDiscount = priceMemberDiscount;
    }
    
}
