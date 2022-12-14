/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team18.salesmanagement.data.product;

import com.team18.salesmanagement.domain.product.Product;
import com.team18.salesmanagement.domain.productpurchase.ProductDetail;
import java.util.List;

/**
 *
 * @author HuuDepTrai
 */
public interface IProductRepository {
    List<Product> getProductList(String keyWords);
    Product getProductbyId(Integer id);
    int saveProduct(Product product);
    int deleteProduct(Integer id);
    List<Product> getProductList();
    ProductDetail getProductDetailById(Integer id);
}
