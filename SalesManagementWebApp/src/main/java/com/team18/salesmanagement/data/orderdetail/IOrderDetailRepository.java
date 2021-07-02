// File: IOrderDetailRepository.java
// Define data access operation for Order Detail
// Author: 1760169 - Le Anh Tai
// Email: leanhtai01@gmail.com
// GitHub: https://github.com/leanhtai01
package com.team18.salesmanagement.data.orderdetail;

import com.team18.salesmanagement.domain.orderdetail.OrderDetail;

public interface IOrderDetailRepository {
    void insert(OrderDetail orderDetail);
}
