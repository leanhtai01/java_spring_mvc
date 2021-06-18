// File: CustomerController.java
// Controller for Customer
// Author: 1760169 - Le Anh Tai
// Email: leanhtai01@gmail.com
// GitHub: https://github.com/leanhtai01
package com.team18.salesmanagement.web.customer;

import com.team18.salesmanagement.data.customer.CustomerRepository;
import com.team18.salesmanagement.domain.customer.Customer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;
    
    // get all Customer's information
    @RequestMapping(value = "/getlist", method = RequestMethod.GET)
    public String displayCustomerList(Model model) {
        List<Customer> customerList = customerRepository.getCustomerList();
        
        model.addAttribute(customerList);
        
        return "customer/customer_list";
    } // end method displayCustomerList
} // end class CustomerController
