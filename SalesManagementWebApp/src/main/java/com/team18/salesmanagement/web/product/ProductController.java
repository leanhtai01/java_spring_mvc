/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team18.salesmanagement.web.product;

import com.team18.salesmanagement.data.product.IProductRepository;
import com.team18.salesmanagement.domain.customer.Customer;
import com.team18.salesmanagement.domain.product.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author HuuDepTrai
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductRepository iProductRepository;
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getProductList(Model model) {
        List<Product> products = iProductRepository.getProductList(null);
        model.addAttribute("products",products);
        return "products/list";
    }
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteProduct(@RequestParam("id") Integer id) {
        int products = iProductRepository.deleteProduct(id);
        return "products/list";
    }
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public String findProduct(@RequestParam("keywords") String keywords, Model model) {
        List<Product> products = iProductRepository.getProductList(keywords);
        model.addAttribute("products",products);
        return "products/list";
    }
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editProduct(@RequestParam("id") Integer id, Model m) {
        Product product = iProductRepository.getProductbyId(id);
        m.addAttribute("product", product);
        return "products/update";
    }
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String editProduct() {
        return "products/update";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product, BindingResult result, ModelMap model) {
        int rs = iProductRepository.saveProduct(product);
        if (rs == 1) {
            return "redirect:list";
        }
        return "products/error";
    }
}
