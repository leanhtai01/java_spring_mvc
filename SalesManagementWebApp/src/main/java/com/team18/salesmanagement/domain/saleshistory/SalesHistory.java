/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team18.salesmanagement.domain.saleshistory;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author minkes
 */
public class SalesHistory implements Serializable {

    private int customer_id;
    private int order_id;
    private String customer_name;
    private BigDecimal total_detail;
    private Date order_date;

    public SalesHistory() {
    }

    public SalesHistory(int customer_id, int order_id, String customer_name, BigDecimal total_detail, Date order_date) {
        this.customer_id = customer_id;
        this.order_id = order_id;
        this.customer_name = customer_name;
        this.total_detail = total_detail;
        this.order_date = order_date;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public BigDecimal getTotal_detail() {
        return total_detail;
    }

    public void setTotal_detail(BigDecimal total_detail) {
        this.total_detail = total_detail;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }
}
