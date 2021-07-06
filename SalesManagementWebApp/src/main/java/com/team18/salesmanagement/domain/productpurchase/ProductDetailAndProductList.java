// File: ProductDetailAndProductList.java
// Class ProductDetailAndProductList represent a composite type of
// ProductDetail and Product List
// Author: 1760169 - Le Anh Tai
// Email: leanhtai01@gmail.com
// GitHub: https://github.com/leanhtai01
package com.team18.salesmanagement.domain.productpurchase;

import com.team18.salesmanagement.domain.product.Product;
import java.io.Serializable;
import java.util.List;

public class ProductDetailAndProductList implements Serializable {
    private ProductDetail productDetail;
    private List<Product> products;

    public ProductDetailAndProductList() {
        productDetail = new ProductDetail();
    }

    public ProductDetailAndProductList(ProductDetail productDetail,
            List<Product> products) {
        this.productDetail = productDetail;
        this.products = products;
    }

    public ProductDetail getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(ProductDetail productDetail) {
        this.productDetail = productDetail;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
