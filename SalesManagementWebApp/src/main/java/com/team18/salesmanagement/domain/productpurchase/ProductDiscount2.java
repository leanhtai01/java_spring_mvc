// File: ProductDiscount2.java
// Class ProductDiscount2 represent a Product Discount using BigDecimal as
// discount value
// Author: 1760169 - Le Anh Tai
// Email: leanhtai01@gmail.com
// GitHub: https://github.com/leanhtai01
package com.team18.salesmanagement.domain.productpurchase;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class ProductDiscount2 implements Serializable {
    private Integer id;
    private Integer productId;
    private BigDecimal discountValue;
    private String discountUnit;
    private LocalDate validFrom;
    private LocalDate validUntil;
    
    public boolean isValid() {
        LocalDate currentDate = LocalDate.now();
        
        if (currentDate.compareTo(validFrom) >= 0
                && currentDate.compareTo(validUntil) <= 0) {
            return true;
        }
        
        return false;
    }

    public ProductDiscount2() {
    }

    public ProductDiscount2(Integer id, Integer productId, BigDecimal discountValue, String discountUnit, LocalDate validFrom, LocalDate validUntil) {
        this.id = id;
        this.productId = productId;
        this.discountValue = discountValue;
        this.discountUnit = discountUnit;
        this.validFrom = validFrom;
        this.validUntil = validUntil;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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

    public LocalDate getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDate validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDate getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(LocalDate validUntil) {
        this.validUntil = validUntil;
    }
}
