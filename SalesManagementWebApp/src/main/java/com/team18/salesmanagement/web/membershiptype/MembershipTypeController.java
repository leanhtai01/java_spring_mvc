// File: MembershipTypeController.java
// Controller for MembershipType
// Author: 1760169 - Le Anh Tai
// Email: leanhtai01@gmail.com
// GitHub: https://github.com/leanhtai01
package com.team18.salesmanagement.web.membershiptype;

import com.team18.salesmanagement.data.membershiptype.IMembershipTypeRepository;
import com.team18.salesmanagement.domain.membershiptype.MembershipType;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/membershiptype")
public class MembershipTypeController {
    @Autowired
    IMembershipTypeRepository membershipTypeRepository;
    
    // get MembershipType list
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String displayMembershipTypeList(Model model) {
        List<MembershipType> membershipTypeList = membershipTypeRepository
                .getList();
        
        model.addAttribute(membershipTypeList);
        
        return "membershiptype/list";
    } // end method displayMembershipTypeList
    
    // display Membership Type Manager page
    @RequestMapping(value = "/manager", method = RequestMethod.GET)
    public String displayManager() {
        return "membershiptype/manager";
    }
    
    // display Membership Type add form
    @RequestMapping(value = "/add_form", method = RequestMethod.GET)
    public String displayAddForm() {
        return "membershiptype/add_form";
    }
    
    // display update form
    @RequestMapping(value = "update_form", method = RequestMethod.GET)
    public String displayUpdateForm(@RequestParam int id, Model model) {
        MembershipType membershipType = membershipTypeRepository
                .getMembershipType(id);
        
        model.addAttribute(membershipType);
        
        return "membershiptype/update_form";
    }
} // end class MembershipTypeController
