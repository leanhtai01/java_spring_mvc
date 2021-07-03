/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team18.salesmanagement.web.saleshistory;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.team18.salesmanagement.data.saleshistory.ISalesHistoryRepository;
import com.team18.salesmanagement.domain.saleshistory.SalesHistory;
import java.sql.Date;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author minkes
 */
@Controller
@RequestMapping("/saleshistory")
public class SalesHistoryController {

    @Autowired
    ISalesHistoryRepository salesHistoryRepository;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String displayDiscountList(Model model) {
        return "saleshistory/index";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String searchDiscount(Model model, @RequestParam("f_from_date") Date fromDate, @RequestParam("f_to_date") Date toDate) {
        List<SalesHistory> history_list = salesHistoryRepository.getHistory(fromDate,toDate);

        model.addAttribute("sales_history",history_list);
        
        return "saleshistory/index";
    }
}   
