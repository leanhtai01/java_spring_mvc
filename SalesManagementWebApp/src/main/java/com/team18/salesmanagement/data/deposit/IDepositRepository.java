/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team18.salesmanagement.data.deposit;

import com.team18.salesmanagement.domain.deposit.Deposit;

/**
 *
 * @author minkes
 */
public interface IDepositRepository {
    void insertDeposit(Deposit deposit);
    Deposit getLastestDepositByCustomerID(int customer_id);
    Deposit getDepositByID(int id);
}
