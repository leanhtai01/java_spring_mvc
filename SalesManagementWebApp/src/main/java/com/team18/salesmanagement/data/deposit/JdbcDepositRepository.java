/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team18.salesmanagement.data.deposit;

import com.team18.salesmanagement.domain.deposit.Deposit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

/**
 *
 * @author minkes
 */
@Repository
public class JdbcDepositRepository implements IDepositRepository {

    private final JdbcOperations jdbcOperations;

    @Autowired
    public JdbcDepositRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public void insertDeposit(Deposit deposit) {
        final String ADD_DEPOSIT = String.format("INSERT INTO `deposits`(`customer_id`,`deposit_amount`,`balance_before_deposit`,`balance_after_deposit`,`deposit_date`) "
                + "VALUES (\'%d\', \'%f\', \'%f\', \'%f\', \'%s\')",
                deposit.getCustomerId(),
                deposit.getDepositAmount(),
                deposit.getBalanceBeforeDeposit(),
                deposit.getBalanceAfterDeposit(), 
                deposit.getDepositDate().toString());
        jdbcOperations.execute(ADD_DEPOSIT);
    }
    
    @Override
    public Deposit getLastestDepositByCustomerID(int customer_id) {
        final String SELECT_LASTEST_DISCOUNT = "SELECT * FROM deposits WHERE customer_id = ? ORDER BY id DESC LIMIT 1;";
        
        return jdbcOperations.queryForObject(SELECT_LASTEST_DISCOUNT,
                (rs, rowNum) -> {
                    return new Deposit(
                            rs.getInt("id"),
                            rs.getInt("customer_id"),
                            rs.getBigDecimal("deposit_amount"),
                            rs.getBigDecimal("balance_before_deposit"),
                            rs.getBigDecimal("balance_after_deposit"),
                            rs.getDate("deposit_date").toLocalDate()
                    );
                }, customer_id);
    }
    
    @Override
    public Deposit getDepositByID(int id){
        final String SELECT_DISCOUNT = "SELECT * FROM deposits WHERE id = ?;";
        
        return jdbcOperations.queryForObject(SELECT_DISCOUNT,
                (rs, rowNum) -> {
                    return new Deposit(
                            rs.getInt("id"),
                            rs.getInt("customer_id"),
                            rs.getBigDecimal("deposit_amount"),
                            rs.getBigDecimal("balance_before_deposit"),
                            rs.getBigDecimal("balance_after_deposit"),
                            rs.getDate("deposit_date").toLocalDate()
                    );
                }, id);
        
    }
}
