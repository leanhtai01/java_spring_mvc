// File: IMembershipTypeRepository
// Define data access operation for MembershipType
// Author: 1760169 - Le Anh Tai
package com.team18.salesmanagement.data.membershiptype;

import com.team18.salesmanagement.domain.membershiptype.MembershipType;
import java.util.List;

public interface IMembershipTypeRepository {
    List<MembershipType> getList();
}
