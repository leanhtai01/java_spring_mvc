// File: OrderFlowActions.java
// Define actions in Order flow
// Author: 1760169 - Le Anh Tai
// Email: leanhtai01@gmail.com
// GitHub: https://github.com/leanhtai01
package com.team18.salesmanagement.flow;

import com.team18.salesmanagement.data.customer.ICustomerRepository;
import com.team18.salesmanagement.data.order.IOrderRepository;
import com.team18.salesmanagement.data.withdraw.IWithdrawRepository;
import com.team18.salesmanagement.domain.productpurchase.Order;
import com.team18.salesmanagement.domain.withdraw.Withdraw;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderFlowActions {
    @Autowired
    IOrderRepository orderRepository;
    
    @Autowired
    IWithdrawRepository withdrawRepository;
    
    @Autowired
    ICustomerRepository customerRepository;
    
    public void saveOrder(Order compositeOrder) {
        // create objects from composite Order
        com.team18.salesmanagement.domain.order.Order basicOrder =
                new com.team18.salesmanagement.domain.order.Order(
                        compositeOrder.getCustomer().getId(),
                        LocalDate.now(),
                        compositeOrder.getDiscountValue(),
                        compositeOrder.getDiscountUnit()
                );
        
        Withdraw withdraw = new Withdraw(
                compositeOrder.getCustomer().getId(),
                compositeOrder.getTotalDiscountPrice(),
                compositeOrder.getCustomer().getBalance(),
                compositeOrder.getBalanceAfterWithDraw(),
                LocalDate.now()
        );
        
        Integer orderId = orderRepository.insert(basicOrder);
        withdrawRepository.insert(withdraw);
        customerRepository.updateBalance(compositeOrder.getCustomer().getId(),
                compositeOrder.getBalanceAfterWithDraw());
    }
}
