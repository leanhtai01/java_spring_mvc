// File: IOrderRepository.java
// Define data access operation for Order
// Author: 1760169 - Le Anh Tai
// Email: leanhtai01@gmail.com
// GitHub: https://github.com/leanhtai01
package com.team18.salesmanagement.data.order;

import com.team18.salesmanagement.domain.order.Order;

public interface IOrderRepository {
    Integer insert(Order order);
}
