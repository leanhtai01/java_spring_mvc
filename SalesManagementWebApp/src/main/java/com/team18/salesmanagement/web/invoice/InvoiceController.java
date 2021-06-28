/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team18.salesmanagement.web.invoice;

import com.team18.salesmanagement.data.invoice.InvoiceInterface;
import com.team18.salesmanagement.domain.invoice.Invoice;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author HuuDepTrai
 */
@Controller
@RequestMapping("/invoice")
public class InvoiceController {
    @Autowired
    InvoiceInterface invoiceInterface;
    
    @RequestMapping("/detail")
    public String findProduct(@RequestParam("order_id") Integer order_id, Model model) {
        Invoice invoice = invoiceInterface.getInvoiceById(order_id);
        model.addAttribute("invoice",invoice);
        return "invoice/detail";
    }
    
}
