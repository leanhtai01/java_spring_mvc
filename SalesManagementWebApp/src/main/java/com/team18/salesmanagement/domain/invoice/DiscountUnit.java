/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team18.salesmanagement.domain.invoice;

/**
 *
 * @author HuuDepTrai
 */
public enum DiscountUnit {
    PERCENT("PERCENT"),
    FLAT_CURRENCY("FLAT_CURRENCY");
    
    
    private String type;
    
    DiscountUnit(String type) {
        this.type = type;
    }
    
    public String getType() {
        return type;
    }
 
    public void setType(String type) {
        this.type = type;
    }
}
