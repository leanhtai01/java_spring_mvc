<%-- 
    Document   : showProductList
    Created on : Jun 29, 2021, 1:17:10 PM
    Author     : leanhtai01
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product List</title>
    </head>
    <body>
        <h2>Product List</h2>
        <sf:form action="${flowExecutionUrl}" method="post" modelAttribute="productDetailAndProductList">
            <sf:select path="productDetail.id">
                <c:forEach var="product" items="${productDetailAndProductList.products}">
                    <option value="${product.id}">${product.name} - ${product.weight} - ${product.price}</option>
                </c:forEach>
            </sf:select>
            <sf:hidden path="productDetail.name" value="garbageName"/>
            <sf:hidden path="productDetail.weight" value="0"/>
            <sf:hidden path="productDetail.price" value="0"/>
            <sf:input path="productDetail.quantity"/>
            <sf:hidden path="productDetail.productDiscountId" value="0"/>
            <sf:hidden path="productDetail.discountValue" value="0"/>
            <sf:hidden path="productDetail.discountUnit" value="PERCENT"/>
            <input type="submit" name="_eventId_add" value="Add"/>
            <input type="submit" name="_eventId_cancel" value="Cancel"/>
        </sf:form>
</body>
</html>
