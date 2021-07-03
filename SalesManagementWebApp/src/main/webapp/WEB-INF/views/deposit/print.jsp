<%-- 
    Document   : print
    Created on : Jun 30, 2021, 1:25:18 AM
    Author     : minkes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Deposit</title>
    </head>
    <body>
        <h1>Deposit</h1>
        <div>
            <label>Deposit ID: </label>
            <p>${deposit.id}</p>
        </div>
        <div>
            <label>Deposit Amount: </label>
            <p>${deposit.depositAmount}</p>
        </div>
        <div>
            <label>Balance Before: </label>
            <p>${deposit.balanceBeforeDeposit}</p>
        </div>
        <div>
            <label>Balance After: </label>
            <p>${deposit.balanceAfterDeposit}</p>
        </div>
        <div>
            <label>Deposit Date: </label>
            <p>${deposit.depositDate}</p>
        </div>
        
        <a href="../">Go Homepage</a>
    </body>
</html>
