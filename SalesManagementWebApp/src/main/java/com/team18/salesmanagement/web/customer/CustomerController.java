// File: CustomerController.java
// Controller for Customer
// Author: 1760169 - Le Anh Tai
// Email: leanhtai01@gmail.com
// GitHub: https://github.com/leanhtai01
package com.team18.salesmanagement.web.customer;

import com.team18.salesmanagement.domain.customer.Customer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.team18.salesmanagement.data.customer.ICustomerRepository;
import com.team18.salesmanagement.data.membershiptype.IMembershipTypeRepository;
import com.team18.salesmanagement.domain.membershiptype.MembershipType;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    ICustomerRepository customerRepository;
    
    @Autowired
    IMembershipTypeRepository membershipTypeRepository;
    
    // get all Customer's information
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String displayCustomerInfo(@RequestParam String phoneNumber,
            Model model) {
        List<Customer> customerList = customerRepository
                .getCustomerInfo(phoneNumber);
        
        model.addAttribute(customerList);
        
        return "customer/list";
    } // end method displayCustomerList
    
    // display Customer Management Page
    @RequestMapping(value = "/manager", method = RequestMethod.GET)
    public String displayManagementPage() {
        return "customer/manager";
    }
    
    // display Customer Search Page
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String displaySearchPage() {
        return "customer/search";
    }
    
    // delete Customer
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteCustomer(@RequestParam int id) {
        customerRepository.deleteCustomer(id);
        
        return "redirect:/customer/list?phoneNumber=";
    }
    
    // display Customer add form
    @RequestMapping(value = "/add_form", method = RequestMethod.GET)
    public String displayAddForm(Model model) {
        List<MembershipType> membershipTypeList = membershipTypeRepository
                .getList();
        model.addAttribute(membershipTypeList);
        
        return "customer/add_form";
    }
    
    // display add success page
    @RequestMapping(value = "add_success", method = RequestMethod.GET)
    public String displayAddSuccess() {
        return "customer/add_success";
    }
    
    // process add new Customer
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAdd(Customer customer, RedirectAttributes model) {
        // insert customer
        
        model.addFlashAttribute(customer);
        
        return "redirect:/customer/add_success";
    }
} // end class CustomerController
