// File: Deposit.java
// Class Deposit represent a Deposit
// Author: 1760169 - Le Anh Tai
// Email: leanhtai01@gmail.com
// GitHub: https://github.com/leanhtai01
package com.team18.salesmanagement.domain.deposit;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Deposit implements Serializable {

    private int id;
    private int customerId;
    private BigDecimal depositAmount;
    private BigDecimal balanceBeforeDeposit;
    private BigDecimal balanceAfterDeposit;
    private LocalDate depositDate;

    public Deposit() {
    }

    public Deposit(int id, int customerId, BigDecimal depositAmount,
            BigDecimal balanceBeforeDeposit, BigDecimal balanceAfterDeposit,
            LocalDate depositDate) {
        this.id = id;
        this.customerId = customerId;
        this.depositAmount = depositAmount;
        this.balanceBeforeDeposit = balanceBeforeDeposit;
        this.balanceAfterDeposit = balanceAfterDeposit;
        this.depositDate = depositDate;
    }

    public Deposit(int customerId, BigDecimal depositAmount, BigDecimal balanceBeforeDeposit, BigDecimal balanceAfterDeposit, LocalDate depositDate) {
        this.customerId = customerId;
        this.depositAmount = depositAmount;
        this.balanceBeforeDeposit = balanceBeforeDeposit;
        this.balanceAfterDeposit = balanceAfterDeposit;
        this.depositDate = depositDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(BigDecimal depositAmount) {
        this.depositAmount = depositAmount;
    }

    public BigDecimal getBalanceBeforeDeposit() {
        return balanceBeforeDeposit;
    }

    public void setBalanceBeforeDeposit(BigDecimal balanceBeforeDeposit) {
        this.balanceBeforeDeposit = balanceBeforeDeposit;
    }

    public BigDecimal getBalanceAfterDeposit() {
        return balanceAfterDeposit;
    }

    public void setBalanceAfterDeposit(BigDecimal balanceAfterDeposit) {
        this.balanceAfterDeposit = balanceAfterDeposit;
    }

    public LocalDate getDepositDate() {
        return depositDate;
    }

    public void setDepositDate(LocalDate depositDate) {
        this.depositDate = depositDate;
    }
}
