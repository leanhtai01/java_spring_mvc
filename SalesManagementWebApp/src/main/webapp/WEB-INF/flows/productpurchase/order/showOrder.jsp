<%-- 
    Document   : showOrder
    Created on : Jun 29, 2021, 9:00:41 AM
    Author     : leanhtai01
--%>

<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Detail</title>
    </head>
    <body>
        <h2>Order Detail:</h2>
        <h3>Customer's information:</h3>
        <b>${order.customer.name}</b><br>
        <b>${order.customer.phoneNumber}</b><br>
        <b>${order.customer.email}</b><br>
        <b>${order.customer.membershipType}</b><br>
        
        <h3>Products:</h3>
        <c:if test="${fn:length(order.productDetails) eq 0}">
            <b>No products in this order!</b>
        </c:if>
        
        <sf:form action="${flowExecutionUrl}" method="post">
            <input type="submit" name="_eventId_addProduct" value="Add Product"/>
            <c:if test="${fn:length(order.productDetails) gt 0}">
                <input type="submit" name="_eventId_checkout" value="Checkout"/>
            </c:if>
            <input type="submit" name="_eventId_cancel" value="Cancel"/>
        </sf:form>
    </body>
</html>
