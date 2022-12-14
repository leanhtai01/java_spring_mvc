// File: Order.java
// Class Order represent an Order in ProductDetail Purchase
// Author: 1760169 - Le Anh Tai
// Email: leanhtai01@gmail.com
// GitHub: https://github.com/leanhtai01
package com.team18.salesmanagement.domain.productpurchase;

import com.team18.salesmanagement.domain.customer.Customer;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable {
    private Integer id;
    private Customer customer;
    private LocalDate orderDate;
    private BigDecimal debtLimit;
    private BigDecimal discountValue;
    private String discountUnit;
    private List<ProductDetail> productDetails;
    
    // get balance after withdraw
    public BigDecimal getBalanceAfterWithDraw() {
        return customer.getBalance().subtract(getTotalDiscountPrice());
    }
    
    // check whether debt limit is exceeded
    public boolean isDebtLimitExceeded() {
        boolean isExceeded = false;
        BigDecimal tmpBalanceAfterWithdraw = getBalanceAfterWithDraw();
        
        if (tmpBalanceAfterWithdraw.compareTo(BigDecimal.ZERO) < 0) {
            if (tmpBalanceAfterWithdraw.abs().compareTo(debtLimit) > 0) {
                isExceeded = true;
            }
        }
        
        return isExceeded;
    }
    
    // get total original price
    public BigDecimal getTotalOriginalPrice() {
        BigDecimal total = BigDecimal.ZERO;
        
        for (ProductDetail productDetail : productDetails) {
            total = total.add(productDetail.getTotalOriginalPrice());
        }
        
        return total;
    }
    
    // get membership discount amount
    public BigDecimal getMembershipDiscountAmount() {
        BigDecimal amount = BigDecimal.ZERO;
        
        if (discountUnit.equals("PERCENT")) {
            amount = getTotalOriginalPrice()
                    .multiply(discountValue.divide(BigDecimal.valueOf(100)));
        }
        else if (discountUnit.equals("FLAT_CURRENCY")) {
            amount = discountValue;
        }
        
        return amount;
    }
    
    // get total product discount amount
    public BigDecimal getTotalProductDiscountAmount() {
        BigDecimal totalAmount = BigDecimal.ZERO;
        
        for (ProductDetail productDetail : productDetails) {
            totalAmount = totalAmount.add(productDetail.getTotalDiscountAmountPerProduct());
        }
        
        return totalAmount;
    }
    
    // get total discount amount
    public BigDecimal getTotalDiscountAmount() {
        return getMembershipDiscountAmount().add(getTotalProductDiscountAmount());
    }
    
    // get total discount price
    public BigDecimal getTotalDiscountPrice() {
        return getTotalOriginalPrice().subtract(getTotalDiscountAmount());
    }
    
    public void addProductDetail(ProductDetail productDetail) {
        if (productDetail.getQuantity() > 0) {
            int index = -1;
            
            for (int i = 0; i < productDetails.size(); ++i) {
                if ((int) productDetails.get(i).getId()
                        == (int) productDetail.getId()) { // must be convert to int to compare by == operator
                    index = i;
                    break;
                }
            }
            
            if (index != -1) {
                ProductDetail oldProductDetail = productDetails.get(index);
                
                oldProductDetail.setQuantity(oldProductDetail.getQuantity()
                        + productDetail.getQuantity());
                oldProductDetail.setDiscountValue(
                        productDetail.getDiscountValue());
                oldProductDetail.setDiscountUnit(
                        productDetail.getDiscountUnit());
            }
            else {
                productDetails.add(productDetail);
            }
        }
    }

    public Order() {
        customer = new Customer();
        productDetails = new ArrayList<>();
    }

    public Order(Integer id, Customer customer, LocalDate orderDate,
            BigDecimal debtLimit,
            BigDecimal discountValue, String discountUnit,
            List<ProductDetail> productDetails) {
        this.id = id;
        this.customer = customer;
        this.orderDate = orderDate;
        this.debtLimit = debtLimit;
        this.discountValue = discountValue;
        this.discountUnit = discountUnit;
        this.productDetails = productDetails;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
    
    public BigDecimal getDebtLimit() {
        return debtLimit;
    }

    public void setDebtLimit(BigDecimal debtLimit) {
        this.debtLimit = debtLimit;
    }

    public BigDecimal getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(BigDecimal discountValue) {
        this.discountValue = discountValue;
    }

    public String getDiscountUnit() {
        return discountUnit;
    }

    public void setDiscountUnit(String discountUnit) {
        this.discountUnit = discountUnit;
    }

    public List<ProductDetail> getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(List<ProductDetail> productDetails) {
        this.productDetails = productDetails;
    }
}
