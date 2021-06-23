// File: CustomerController.java
// Controller for Customer
// Author: 1760169 - Le Anh Tai
// Email: leanhtai01@gmail.com
// GitHub: https://github.com/leanhtai01
package com.team18.salesmanagement.web.customer;

import com.team18.salesmanagement.data.customer.DuplicateEmailException;
import com.team18.salesmanagement.data.customer.DuplicatePhoneNumberException;
import com.team18.salesmanagement.domain.customer.Customer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.team18.salesmanagement.data.customer.ICustomerRepository;
import com.team18.salesmanagement.data.customer.NotExistsCustomerException;
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
    
    // display update success page
    @RequestMapping(value = "update_success", method = RequestMethod.GET)
    public String displayUpdateSuccess() {
        return "customer/update_success";
    }
    
    // process add new Customer
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAdd(Customer customer, RedirectAttributes model) {
        try {
            customerRepository.insert(customer);
            
            model.addFlashAttribute(customer);
        
            return "redirect:/customer/add_success";
        }
        catch (DuplicatePhoneNumberException e) {
            model.addAttribute("phoneNumber", customer.getPhoneNumber());
            
            return "error/duplicate_phone_number";
        }
        catch (DuplicateEmailException e) {
            model.addAttribute("email", customer.getEmail());
            
            return "error/duplicate_email";
        }
    }
    
    // display update form
    @RequestMapping(value = "update_form", method = RequestMethod.GET)
    public String displayUpdateForm(@RequestParam int id, Model model) {
        List<MembershipType> membershipTypeList = membershipTypeRepository
                .getList();
        Customer customer = customerRepository.getCustomer(id);
        
        model.addAttribute(membershipTypeList);
        model.addAttribute(customer);
        
        return "customer/update_form";
    }
    
    // process update Customer
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String processUpdate(Customer customer, RedirectAttributes model) {
        try {
            customerRepository.update(customer);
        
            model.addFlashAttribute(customer);
        
            return "redirect:/customer/update_success";
        }
        catch (DuplicatePhoneNumberException e) {
            model.addAttribute("phoneNumber", customer.getPhoneNumber());
            
            return "error/duplicate_phone_number";
        }
        catch (DuplicateEmailException e) {
            model.addAttribute("email", customer.getEmail());
            
            return "error/duplicate_email";
        }
        catch (NotExistsCustomerException e) {
            return "error/not_exists_customer";
        }
    }
} // end class CustomerController
