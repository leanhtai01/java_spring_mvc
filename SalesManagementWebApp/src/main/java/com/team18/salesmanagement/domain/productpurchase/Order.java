// File: Order.java
// Class Order represent an Order in Product Purchase
// Author: 1760169 - Le Anh Tai
// Email: leanhtai01@gmail.com
// GitHub: https://github.com/leanhtai01
package com.team18.salesmanagement.domain.productpurchase;

import com.team18.salesmanagement.domain.customer.Customer;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Order implements Serializable {
    private Integer id;
    private Customer customer;
    private LocalDate orderDate;
    private BigDecimal discountValue;
    private String discountUnit;
    private List<Product> products;
    
    public void addProduct(Product product) {
        products.add(product);
    }

    public Order() {
        customer = new Customer();
    }

    public Order(Integer id, Customer customer, LocalDate orderDate,
            BigDecimal discountValue, String discountUnit,
            List<Product> products) {
        this.id = id;
        this.customer = customer;
        this.orderDate = orderDate;
        this.discountValue = discountValue;
        this.discountUnit = discountUnit;
        this.products = products;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
