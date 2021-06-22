/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team18.salesmanagement.data.productdiscount;

import com.team18.salesmanagement.domain.productdiscount.ProductDiscount;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

/**
 *
 * @author leanhtai01
 */
@Repository
public class JdbcProductDiscountRepository implements IProductDiscountRepository {
    
    private final JdbcOperations jdbcOperations;
    
    @Autowired
    public JdbcProductDiscountRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }
    
    @Override
    public List<ProductDiscount> getProductDiscountList() {
        final String SELECT_ALL_DISCOUNT = "SELECT * FROM product_discounts;";
        
        return jdbcOperations.query(SELECT_ALL_DISCOUNT,
                (rs, rowNum) -> {
                    return new ProductDiscount(
                            rs.getInt("id"),
                            rs.getInt("product_id"),
                            rs.getFloat("discount_value"),
                            rs.getString("discount_unit"),
                            rs.getString("valid_from"),
                            rs.getString("valid_until")
                    );
                });
    }
    
    @Override
    public List<ProductDiscount> getDiscountFromProductName(String product_name) {
        final String SEARCH_DISCOUNT = String.format("SELECT pd.* FROM `product_discounts` pd join `products` p on pd.`product_id` = p.`id` where p.`name` like \'%%%s%%\' ", product_name);
        
        return jdbcOperations.query(SEARCH_DISCOUNT,
                (rs, rowNum) -> {
                    return new ProductDiscount(
                            rs.getInt("id"),
                            rs.getInt("product_id"),
                            rs.getFloat("discount_value"),
                            rs.getString("discount_unit"),
                            rs.getString("valid_from"),
                            rs.getString("valid_until")
                    );
                });
    }
    
    @Override
    public void addProductDiscount(ProductDiscount product_discount) {
        final String ADD_DISCOUNT = String.format("INSERT INTO `product_discounts`(`product_id`,`discount_value`,`discount_unit`,`valid_from`,`valid_until`) VALUES (\'%d\', \'%f\', \'%s\', \'%s\', \'%s\')", 
                product_discount.getProduct_id(), product_discount.getDiscount_value(), product_discount.getDiscount_unit(), product_discount.getValid_from(), product_discount.getValid_until());
        
        jdbcOperations.execute(ADD_DISCOUNT);
    }
    
    @Override
    public void updateProductDiscount(ProductDiscount product_discount) {
        final String UPDATE_DISCOUNT = String.format("UPDATE `product_discounts` SET `product_id` = \'%d\',`discount_value` = \'%f\',`discount_unit` = \'%s\',`valid_from` = \'%s\',`valid_until` = \'%s\' WHERE `id` = \'%d\' ", 
                product_discount.getProduct_id(), product_discount.getDiscount_value(), product_discount.getDiscount_unit(), product_discount.getValid_from(), product_discount.getValid_until(), product_discount.getId());
        
        jdbcOperations.execute(UPDATE_DISCOUNT);
    }
    
    @Override
    public void deleteProductDiscount(Integer id) {
        final String DELETE_DISCOUNT = String.format("DELETE FROM `product_discounts` WHERE `id` = \'%d\' ", id);
        
        jdbcOperations.execute(DELETE_DISCOUNT);
    }
}
