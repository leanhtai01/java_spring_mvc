/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team18.salesmanagement.web.productdiscount;

import com.team18.salesmanagement.data.product.IProductRepository;
import com.team18.salesmanagement.domain.productdiscount.ProductDiscount;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.team18.salesmanagement.data.productdiscount.IProductDiscountRepository;
import com.team18.salesmanagement.domain.product.Product;
import com.team18.salesmanagement.domain.productdiscount.DiscountWithProductName;
import java.sql.Date;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author leanhtai01
 */
@Controller
@RequestMapping("/discount")
public class ProductDiscountController {

    @Autowired
    IProductDiscountRepository productDiscountRepository;

    @Autowired
    IProductRepository productRepository;

    // get all Discount's information
    @RequestMapping(value = "/getlist", method = RequestMethod.GET)
    public String displayDiscountList(Model model) {
        List<DiscountWithProductName> productDiscountList = productDiscountRepository.getDiscountWithProductNameList();
        List<Product> productList = productRepository.getProductList();

        model.addAttribute("productList", productList);
        model.addAttribute("productDiscountList", productDiscountList);

        return "product_discount/product_discount_list";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchDiscount(Model model, @RequestParam("name") String product_name) {

        List<DiscountWithProductName> productDiscountList = productDiscountRepository.getDiscountWithProductNameFromProductName(product_name);
        List<Product> productList = productRepository.getProductList();

        model.addAttribute("productList", productList);
        model.addAttribute("productDiscountList", productDiscountList);
        return "product_discount/product_discount_list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addDiscount(Model model, @RequestParam("f_product_id") Integer product_id,
            @RequestParam("f_discount_value") Float discount_value, @RequestParam("f_discount_unit") String discount_unit,
            @RequestParam("f_valid_from") Date valid_from, @RequestParam("f_valid_until") Date valid_until) {

        ProductDiscount product_discount = new ProductDiscount(product_id, discount_value, discount_unit, valid_from.toLocalDate(), valid_until.toLocalDate());

        productDiscountRepository.addProductDiscount(product_discount);

        return "redirect:getlist";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateDiscount(Model model, @RequestParam("f_id") Integer id) {
        List<DiscountWithProductName> productDiscountList = productDiscountRepository.getDiscountWithProductNameList();
        List<Product> productList = productRepository.getProductList();

        model.addAttribute("productDiscountList", productDiscountList);
        model.addAttribute("productList", productList);

        model.addAttribute("discount_id", id);

        return "product_discount/product_discount_list";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveDiscount(Model model, @RequestParam("f_id") Integer id, @RequestParam("f_product_id") Integer product_id,
            @RequestParam("f_discount_value") Float discount_value, @RequestParam("f_discount_unit") String discount_unit,
            @RequestParam("f_valid_from") Date valid_from, @RequestParam("f_valid_until") Date valid_until) {

        ProductDiscount product_discount = new ProductDiscount(id, product_id, discount_value, discount_unit, valid_from.toLocalDate(), valid_until.toLocalDate());

        productDiscountRepository.updateProductDiscount(product_discount);

        return "redirect:getlist";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteDiscount(Model model, @RequestParam("f_id") Integer id) {
        productDiscountRepository.deleteProductDiscount(id);

        return "redirect:getlist";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String testDiscount(Model model) {
                List<DiscountWithProductName> productDiscountList = productDiscountRepository.getDiscountWithProductNameList();
        model.addAttribute("productDiscountList", productDiscountList);

        return "product_discount/partials/discount_list_tbody";
    }
}
