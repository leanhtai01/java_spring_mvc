// File: ICustomerRepository.java
// Define data access operation for Customer
// Author: 1760169 - Le Anh Tai
// Email: leanhtai01@gmail.com
// GitHub: https://github.com/leanhtai01
package com.team18.salesmanagement.data.customer;

import com.team18.salesmanagement.domain.customer.Customer;
import java.util.List;

public interface ICustomerRepository {
    List<Customer> getCustomerInfo(String phoneNumber);
    void deleteCustomer(int id);
}
