<%-- 
    Document   : debtLimitExceededWarning
    Created on : Jul 1, 2021, 11:21:32 PM
    Author     : leanhtai01
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Warning!!!</title>
    </head>
    <body>
        <h2>Warning!!! Debt limit exceeded!</h2>
        <h3>Information:</h3>
        <b>Customer's debt limit: ${order.debtLimit}</b><br>
        <b>Customer's current balance: ${order.balance}</b><br>
        <b>Total price user must pay: ${order.totalDiscountPrice}</b><br>
        <b>Balance if checkout is perform: ${order.balanceAfterWithDraw}</b><br>

        <br><hr>

        <p>Allow purchasing of this customer?</p>
        <a href="${flowExecutionUrl}&_eventId=accept">Accept</a> | 
        <a href="${flowExecutionUrl}&_eventId=cancel">Cancel</a>
    </body>
</html>
