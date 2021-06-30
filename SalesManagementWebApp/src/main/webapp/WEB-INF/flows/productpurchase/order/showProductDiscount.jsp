<%-- 
    Document   : showProductDiscount
    Created on : Jun 30, 2021, 8:21:25 AM
    Author     : leanhtai01
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Discounts</title>
    </head>
    <body>
        <h2>Product Discounts</h2>
        <form action="${flowExecutionUrl}" method="post">
            Discount: <select name="productDiscountId">
                <c:forEach var="discount" items="${productDiscountList}">
                    <option value="${discount.id}">${discount.discountValue} - ${discount.discountUnit}</option>
                </c:forEach>
            </select><br>
            <input type="submit" name="_eventId_add" value="Add"/>
            <input type="submit" name="_eventId_cancel" value="Cancel"/>
        </form>
    </body>
</html>
