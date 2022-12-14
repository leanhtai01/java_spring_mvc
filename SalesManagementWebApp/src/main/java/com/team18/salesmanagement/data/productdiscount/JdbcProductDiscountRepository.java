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
import java.sql.Date;
import java.util.ArrayList;
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
                            rs.getDate("valid_from").toLocalDate(),
                            rs.getDate("valid_until").toLocalDate()
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
                            rs.getDate("valid_from").toLocalDate(),
                            rs.getDate("valid_until").toLocalDate()
                    );
                });
    }
    
    @Override
    public List<DiscountWithProductName> getDiscountWithProductNameList(){
        final String SELECT_ALL_DISCOUNT = "select d.*, p.name as product_name, p.weight as product_weight from product_discounts d join products p on d.product_id = p.id order by d.id;";
        
        return jdbcOperations.query(SELECT_ALL_DISCOUNT,
                (rs, rowNum) -> {
                    return new DiscountWithProductName(
                            rs.getInt("id"),
                            rs.getInt("product_id"),
                            rs.getString("product_name"),
                            rs.getDouble("product_weight"),
                            rs.getFloat("discount_value"),
                            rs.getString("discount_unit"),
                            rs.getDate("valid_from").toLocalDate(),
                            rs.getDate("valid_until").toLocalDate()
                    );
                });
    }
    
    @Override
    public List<DiscountWithProductName> getDiscountWithProductNameFromProductName(String product_name){
        final String SEARCH_DISCOUNT = String.format("select d.*, p.name as product_name, p.weight as product_weight from product_discounts d join products p on d.product_id = p.id where p.`name` like \'%%%s%%\' order by d.id", product_name);

        return jdbcOperations.query(SEARCH_DISCOUNT,
                (rs, rowNum) -> {
                    return new DiscountWithProductName(
                            rs.getInt("id"),
                            rs.getInt("product_id"),
                            rs.getString("product_name"),
                            rs.getDouble("product_weight"),
                            rs.getFloat("discount_value"),
                            rs.getString("discount_unit"),
                            rs.getDate("valid_from").toLocalDate(),
                            rs.getDate("valid_until").toLocalDate()
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
    
    // check whether product have discount
    @Override
    public boolean hasDiscounts(Integer productId) {
        final String GET_DISCOUNTS = "SELECT * FROM product_discounts"
                + " WHERE product_id = ?";
        List<ProductDiscount2> discountList = jdbcOperations
                .query(GET_DISCOUNTS,
                (rs, rowNum) -> {
                    return new ProductDiscount2(
                            rs.getInt("id"),
                            rs.getInt("product_id"),
                            rs.getBigDecimal("discount_value"),
                            rs.getString("discount_unit"),
                            ((Date) rs.getDate("valid_from")).toLocalDate(),
                            ((Date) rs.getDate("valid_until")).toLocalDate()
                    );
                }, productId);
        
        for (ProductDiscount2 discount : discountList) {
            if (discount.isValid()) {
                return true;
            }
        }
        
        return false;
    }
    
    // get discounts by given product id
    @Override
    public List<ProductDiscount2> getProductDiscounts(Integer productId) {
        final String GET_DISCOUNTS = "SELECT * FROM product_discounts"
                + " WHERE product_id = ?";
        
        List<ProductDiscount2> discountList = jdbcOperations
                .query(GET_DISCOUNTS,
                (rs, rowNum) -> {
                    return new ProductDiscount2(
                            rs.getInt("id"),
                            rs.getInt("product_id"),
                            rs.getBigDecimal("discount_value"),
                            rs.getString("discount_unit"),
                            ((Date) rs.getDate("valid_from")).toLocalDate(),
                            ((Date) rs.getDate("valid_until")).toLocalDate()
                    );
                }, productId);
        
        List<ProductDiscount2> validDiscounts = new ArrayList<>();
        
        for (ProductDiscount2 discount : discountList) {
            if (discount.isValid()) {
                validDiscounts.add(discount);
            }
        }
        
        return validDiscounts;
    }
    
    // get product discount value by given product discount id
    @Override
    public BigDecimal getProductDiscountValue(Integer id) {
        final String GET_DISCOUNT = "SELECT * FROM product_discounts"
                + " WHERE id = ?";
        ProductDiscount2 productDiscount
                = jdbcOperations.queryForObject(GET_DISCOUNT,
                        (rs, rowNum) -> {
                            return new ProductDiscount2(
                                    rs.getInt("id"),
                                    rs.getInt("product_id"),
                                    rs.getBigDecimal("discount_value"),
                                    rs.getString("discount_unit"),
                                    ((Date) rs.getDate("valid_from")).toLocalDate(),
                                    ((Date) rs.getDate("valid_until")).toLocalDate()
                            );
                        }, id);
        
        return productDiscount.getDiscountValue();
    }
    
    // get product discount unit by given product discount id
    @Override
    public String getProductDiscountUnit(Integer id) {
        final String GET_DISCOUNT = "SELECT * FROM product_discounts"
                + " WHERE id = ?";
        ProductDiscount2 productDiscount
                = jdbcOperations.queryForObject(GET_DISCOUNT,
                        (rs, rowNum) -> {
                            return new ProductDiscount2(
                                    rs.getInt("id"),
                                    rs.getInt("product_id"),
                                    rs.getBigDecimal("discount_value"),
                                    rs.getString("discount_unit"),
                                    ((Date) rs.getDate("valid_from")).toLocalDate(),
                                    ((Date) rs.getDate("valid_until")).toLocalDate()
                            );
                        }, id);
        
        return productDiscount.getDiscountUnit();
    }
}
