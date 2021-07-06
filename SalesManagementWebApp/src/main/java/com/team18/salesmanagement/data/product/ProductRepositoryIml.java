/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team18.salesmanagement.data.product;

import com.team18.salesmanagement.domain.product.Product;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HuuDepTrai
 */
@Repository
public class ProductRepositoryIml implements IProductRepository{
    private final JdbcOperations jdbcOperations;
    
    @Autowired
    public ProductRepositoryIml(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }
    @Override
    public List<Product> getProductList(String keyWords){
        List<Product> result = new ArrayList<>();
        String SQL = "select * from products";
        if(keyWords != null && !keyWords.isBlank() ) {
            SQL = "select * from products WHERE name like '%" + keyWords + "%' or price ='" + keyWords + "'";
        }
        result = jdbcOperations.query(SQL, (rs, rowNum) -> {
                    return new Product(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getDouble("weight"),
                            rs.getDouble("price")
                    );
                });
        return result;
    }
    @Override
    public Product getProductbyId(Integer id){
        Product result = new Product();
        String SQL = "select * from products where id="+ id;
        result = (Product) jdbcOperations.queryForObject(SQL, (rs, rowNum) -> {
                    return new Product(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getDouble("weight"),
                            rs.getDouble("price")
                    );
                });
        return result;
    }
    @Override
    public int deleteProduct(Integer id){
        int result = 0;
        String SQL = "delete FROM products where id = ?";
        result = jdbcOperations.update(SQL, id);
        return result;
    }
    
    @Override
    public int saveProduct(Product product){
        int result = 0;
        String SQL = "";
        try {
            if (product.getId() != null) {
                SQL = "UPDATE products SET name=?, weight=?, price=? WHERE id = ?";
                result = jdbcOperations.update(SQL, product.getName(), product.getWeight(), product.getPrice(), product.getId());
            } else {
                SQL = "INSERT INTO products(name, weight, price) VALUES (?,?,?)";
                result = jdbcOperations.update(SQL, product.getName(), product.getWeight(), product.getPrice());
            }
        } catch (Exception e) {
            result = 0;
        }
        
        return result;
    }
    
    @Override
    public List<Product> getProductList() {
        final String GET_PRODUCTS = "SELECT * FROM products;";
        
        return jdbcOperations.query(GET_PRODUCTS,
                (rs, rowNum) -> {
                    return new Product(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getDouble("weight"),
                            rs.getDouble("price")
                    );
                });
    }
}
