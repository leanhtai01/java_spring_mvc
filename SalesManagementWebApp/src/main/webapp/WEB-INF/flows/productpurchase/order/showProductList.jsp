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
        <table>
            <th>name</th>
            <th>weight</th>
            <th>price</th>
            <th>quantity</th>
            <c:forEach var="product" items="${productDetailAndProductList.products}">
            <tr>
                <sf:form modelAttribute="productDetailAndProductList.productDetail">
                <input type="hidden" path="productDetail.id" value="product.id"/>
                <input type="hidden" path="productDetail.productDiscountId" value="0"/>
                <input type="hidden" path="productDetail.discountValue" value="0"/>
                <input type="hidden" path="productDetail.discountUnit" value="PERCENT"/>
                <td><input type="hidden" path="productDetail.name" value="product.name"/>${product.name}</td>
                <td><input type="hidden" path="productDetail.weight" value="product.weight"/>${product.weight}</td>
                <td><input type="hidden" path="productDetail.price" value="product.price"/>${product.price}</td>
                <td><input type="text" path="productDetail.quantity"/></td>
                <td><input type="submit" name="_eventId_add" value="Add"/></td>
                </sf:form>
            </tr>
            </c:forEach>
        </table>
        <form action="${flowExecutionUrl}" method="post">
            <input type="submit" name="_eventId_cancel" value="Cancel"/>
        </form>
    </body>
</html>
