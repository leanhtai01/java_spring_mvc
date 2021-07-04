/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team18.salesmanagement.data.productdiscount;

import com.team18.salesmanagement.domain.productdiscount.DiscountWithProductName;
import com.team18.salesmanagement.domain.productdiscount.ProductDiscount;
import com.team18.salesmanagement.domain.productpurchase.ProductDiscount2;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author minkes
 */
public interface IProductDiscountRepository {
    List<ProductDiscount> getProductDiscountList();
    List<ProductDiscount> getDiscountFromProductName(String product_name);
    List<DiscountWithProductName> getDiscountWithProductNameList();
    List<DiscountWithProductName> getDiscountWithProductNameFromProductName(String product_name);
    void addProductDiscount(ProductDiscount product_discount);
    void updateProductDiscount(ProductDiscount product_discount);
    void deleteProductDiscount(Integer id);
    boolean hasDiscounts(Integer productId);
    List<ProductDiscount2> getProductDiscounts(Integer productId);
    BigDecimal getProductDiscountValue(Integer id);
    String getProductDiscountUnit(Integer id);
}
