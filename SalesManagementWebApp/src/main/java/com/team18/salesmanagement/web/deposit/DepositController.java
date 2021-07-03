/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team18.salesmanagement.web.deposit;

import com.team18.salesmanagement.data.customer.ICustomerRepository;
import com.team18.salesmanagement.data.deposit.IDepositRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.team18.salesmanagement.domain.customer.Customer;
import com.team18.salesmanagement.domain.deposit.Deposit;
import java.math.BigDecimal;
import java.sql.Date;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author minkes
 */
@Controller
@RequestMapping("/deposit")
public class DepositController {

    @Autowired
    ICustomerRepository customerRepository;
    
    @Autowired
    IDepositRepository depositRepository;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addDeposit(Model model) {
        List<Customer> list_customer = customerRepository.getCustomerInfo("");

        model.addAttribute("list_customer", list_customer);

        return "deposit/add_deposit";
    }

    @RequestMapping(value = "/submit", method = RequestMethod.GET)
    public String confirmDeposit(Model model, @RequestParam("f_customer_id") Integer id,
            @RequestParam("f_deposit_amount") BigDecimal deposit_amount, @RequestParam("f_deposit_date") Date deposit_date) {
        Customer customer = customerRepository.getCustomer(id);
        
        model.addAttribute("customer", customer);
        model.addAttribute("deposit_date", deposit_date);
        model.addAttribute("deposit_amount", deposit_amount);

        return "deposit/confirm";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String saveDeposit(Model model, @RequestParam("f_customer_id") Integer customer_id, @RequestParam("f_balance_before") BigDecimal balance_before,
            @RequestParam("f_balance_after") BigDecimal balance_after, @RequestParam("f_deposit_amount") BigDecimal deposit_amount, 
            @RequestParam("f_deposit_date") Date deposit_date) {
        
        Customer customer = customerRepository.getCustomer(customer_id);
        
        Deposit deposit = new Deposit(customer_id, deposit_amount, balance_before, balance_after , deposit_date.toLocalDate());
        
        customer.setBalance(balance_after);
        customerRepository.update(customer);
        
        depositRepository.insertDeposit(deposit);
        
        model.addAttribute("customer_id", customer_id);
        return "deposit/success";
    }
    
    @RequestMapping(value = "/print", method = RequestMethod.GET)
    public String printDeposit(Model model, @RequestParam("id") Integer id) {
        
        Deposit lastest_deposit = depositRepository.getLastestDepositByCustomerID(id);
        model.addAttribute("deposit", lastest_deposit);
        
        return "deposit/print";
    }
}
