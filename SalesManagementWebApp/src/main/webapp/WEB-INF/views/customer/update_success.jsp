<%-- 
    Document   : update_success
    Created on : Jun 22, 2021, 4:55:11 PM
    Author     : leanhtai01
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update successfully!</title>
    </head>
    <body>
        <h1>Update Customer successfully!</h1>
        <h2>The Customer's information is:</h2>
        <ul>
            <li>Name: ${customer.name}</li>
            <li>Phone number: ${customer.phoneNumber}</li>
            <li>Email: ${customer.email}</li>
            <li>Balance: ${customer.balance}</li>
            <li>Membership Type: ${customer.membershipTypeId}</li>
        </ul>
    </body>
</html>
