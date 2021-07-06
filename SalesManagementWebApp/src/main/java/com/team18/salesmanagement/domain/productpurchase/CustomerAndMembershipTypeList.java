// File: CustomerAndMembershipTypeList.java
// Class CustomerAndMembershipTypeList represent composite type of Customer
// and MembershipType list
// Author: 1760169 - Le Anh Tai
// Email: leanhtai01@gmail.com
// GitHub: https://github.com/leanhtai01
package com.team18.salesmanagement.domain.productpurchase;

import com.team18.salesmanagement.domain.customer.Customer;
import com.team18.salesmanagement.domain.membershiptype.MembershipType;
import java.io.Serializable;
import java.util.List;

public class CustomerAndMembershipTypeList implements Serializable {
    private Customer customer;
    private List<MembershipType> membershipTypes;

    public CustomerAndMembershipTypeList() {
        customer = new Customer();
    }

    public CustomerAndMembershipTypeList(Customer customer,
            List<MembershipType> membershipTypes) {
        this.customer = customer;
        this.membershipTypes = membershipTypes;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<MembershipType> getMembershipTypes() {
        return membershipTypes;
    }

    public void setMembershipTypes(List<MembershipType> membershipTypes) {
        this.membershipTypes = membershipTypes;
    }
}
