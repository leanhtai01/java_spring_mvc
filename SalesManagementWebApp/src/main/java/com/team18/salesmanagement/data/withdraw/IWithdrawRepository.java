// File: IWithdrawRepository
// Define data access operations for Withdraw
// Author: 1760169 - Le Anh Tai
// Email: leanhtai01@gmail.com
// GitHub: https://github.com/leanhtai01
package com.team18.salesmanagement.data.withdraw;

import com.team18.salesmanagement.domain.withdraw.Withdraw;

public interface IWithdrawRepository {
    void insert(Withdraw withdraw);
}
