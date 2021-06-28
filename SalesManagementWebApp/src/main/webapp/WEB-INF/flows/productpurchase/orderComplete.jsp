<%-- 
    Document   : thank_customer
    Created on : Jun 28, 2021, 10:30:25 AM
    Author     : leanhtai01
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Complete!</title>
    </head>
    <body>
        <h2>The order is complete successfully! ${order.customerId}</h2>
        <a href='${flowExecutionUrl}&_eventId=finished'>Finish</a>
    </body>
</html>
