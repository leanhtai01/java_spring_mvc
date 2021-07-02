// File: OrderFlowActions.java
// Define actions in Order flow
// Author: 1760169 - Le Anh Tai
// Email: leanhtai01@gmail.com
// GitHub: https://github.com/leanhtai01
package com.team18.salesmanagement.flow;

import com.team18.salesmanagement.data.order.IOrderRepository;
import com.team18.salesmanagement.domain.productpurchase.Order;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderFlowActions {
    @Autowired
    IOrderRepository orderRepository;
    
    public void saveOrder(Order compositeOrder) {
        // create objects from composite Order
        com.team18.salesmanagement.domain.order.Order basicOrder =
                new com.team18.salesmanagement.domain.order.Order(
                        compositeOrder.getCustomer().getId(),
                        LocalDate.now(),
                        compositeOrder.getDiscountValue(),
                        compositeOrder.getDiscountUnit()
                );
        
        Integer orderId = orderRepository.insert(basicOrder);
    }
}
