// File: Withdraw.java
// Class Withdraw represent a Withdraw
// Author: 1760169 - Le Anh Tai
// Email: leanhtai01@gmail.com
// GitHub: https://github.com/leanhtai01
package com.team18.salesmanagement.domain.withdraw;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Withdraw implements Serializable {
    private Integer id;
    private Integer customerId;
    private BigDecimal withdrawAmount;
    private BigDecimal balanceBeforeWithdraw;
    private BigDecimal balanceAfterWithdraw;
    private LocalDate withdrawDate;

    public Withdraw() {
    }

    public Withdraw(Integer customerId, BigDecimal withdrawAmount,
            BigDecimal balanceBeforeWithdraw, BigDecimal balanceAfterWithdraw,
            LocalDate withdrawDate) {
        this.customerId = customerId;
        this.withdrawAmount = withdrawAmount;
        this.balanceBeforeWithdraw = balanceBeforeWithdraw;
        this.balanceAfterWithdraw = balanceAfterWithdraw;
        this.withdrawDate = withdrawDate;
    }

    public Withdraw(Integer id, Integer customerId, BigDecimal withdrawAmount,
            BigDecimal balanceBeforeWithdraw, BigDecimal balanceAfterWithdraw,
            LocalDate withdrawDate) {
        this.id = id;
        this.customerId = customerId;
        this.withdrawAmount = withdrawAmount;
        this.balanceBeforeWithdraw = balanceBeforeWithdraw;
        this.balanceAfterWithdraw = balanceAfterWithdraw;
        this.withdrawDate = withdrawDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getWithdrawAmount() {
        return withdrawAmount;
    }

    public void setWithdrawAmount(BigDecimal withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }

    public BigDecimal getBalanceBeforeWithdraw() {
        return balanceBeforeWithdraw;
    }

    public void setBalanceBeforeWithdraw(BigDecimal balanceBeforeWithdraw) {
        this.balanceBeforeWithdraw = balanceBeforeWithdraw;
    }

    public BigDecimal getBalanceAfterWithdraw() {
        return balanceAfterWithdraw;
    }

    public void setBalanceAfterWithdraw(BigDecimal balanceAfterWithdraw) {
        this.balanceAfterWithdraw = balanceAfterWithdraw;
    }

    public LocalDate getWithdrawDate() {
        return withdrawDate;
    }

    public void setWithdrawDate(LocalDate withdrawDate) {
        this.withdrawDate = withdrawDate;
    }
}
