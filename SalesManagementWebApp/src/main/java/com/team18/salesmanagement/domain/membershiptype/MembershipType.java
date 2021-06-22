// File: MembershipType.java
// Class MembershipType represent a MembershipType
// Author: 1760169 - Le Anh Tai
// Email: leanhtai01@gmail.com
// GitHub: https://github.com/leanhtai01
package com.team18.salesmanagement.domain.membershiptype;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class MembershipType implements Serializable {
    private int id;
    private String membershipType;
    private BigDecimal debtLimit;
    private BigDecimal discountValue;
    private String discountUnit;
    private LocalDate validFrom;
    private LocalDate validUntil;

    public MembershipType() {}

    public MembershipType(int id, String membershipType, BigDecimal debtLimit,
            BigDecimal discountValue, String discountUnit, LocalDate validFrom,
            LocalDate validUntil) {
        this.id = id;
        this.membershipType = membershipType;
        this.debtLimit = debtLimit;
        this.discountValue = discountValue;
        this.discountUnit = discountUnit;
        this.validFrom = validFrom;
        this.validUntil = validUntil;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public BigDecimal getDebtLimit() {
        return debtLimit;
    }

    public void setDebtLimit(BigDecimal debtLimit) {
        this.debtLimit = debtLimit;
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
