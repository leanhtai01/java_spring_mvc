<%-- 
    Document   : customer_list
    Created on : Jun 17, 2021, 2:34:41 PM
    Author     : leanhtai01
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/main.css">
        <title>Customer List</title>
    </head>
    <body>
        <h1>All Customer's information</h1>
        <table>
            <th>name</th>
            <th>phone_number</th>
            <th>email</th>
            <th>balance</th>
            <th>membership_type</th>
            
            <c:forEach var="customer" items="${customerList}">
                <tr>
                    <td>${customer.name}</td>
                    <td>${customer.phoneNumber}</td>
                    <td>${customer.email}</td>
                    <td>${customer.balance}</td>
                    <td>${customer.membershipType}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
