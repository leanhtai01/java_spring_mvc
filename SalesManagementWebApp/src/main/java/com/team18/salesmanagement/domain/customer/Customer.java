// File: Customer.java
// Class Customer represent a Customer
// Author: 1760169 - Le Anh Tai
// Email: leanhtai01@gmail.com
// GitHub: https://github.com/leanhtai01
package com.team18.salesmanagement.domain.customer;

import java.io.Serializable;
import java.math.BigDecimal;

public class Customer implements Serializable {
    private Integer id;
    private String name;
    private String phoneNumber;
    private String email;
    private BigDecimal balance;
    private Integer membershipTypeId;
    private String membershipType;

    public Customer() {}

    public Customer(Integer id, String name, String phoneNumber, String email, BigDecimal balance, Integer membershipTypeId) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.balance = balance;
        this.membershipTypeId = membershipTypeId;
    }

    public Customer(Integer id, String name, String phoneNumber, String email,
            BigDecimal balance, Integer membershipTypeId,
            String membershipType) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.balance = balance;
        this.membershipTypeId = membershipTypeId;
        this.membershipType = membershipType;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Integer getMembershipTypeId() {
        return membershipTypeId;
    }

    public void setMembershipTypeId(Integer membershipTypeId) {
        this.membershipTypeId = membershipTypeId;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }
} // end class Customer
