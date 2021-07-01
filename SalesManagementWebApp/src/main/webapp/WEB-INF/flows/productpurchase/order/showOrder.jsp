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
        <b>Balance: ${order.customer.balance}</b><br>
        <b>Order discount value: ${order.discountValue}</b><br>
        <b>Order discount unit: ${order.discountUnit}</b><br>
        <b>Debt limit: ${order.debtLimit}</b><br>

        <h3>Products:</h3>
        <c:if test="${fn:length(order.productDetails) eq 0}">
            <b>No products in this order!</b>
        </c:if>

        <c:if test="${fn:length(order.productDetails) gt 0}">
            <table>
                <th>id</th>
                <th>name</th>
                <th>weight</th>
                <th>price</th>
                <th>quantity</th>
                <th>productDiscountId</th>
                <th>discountValue</th>
                <th>discountUnit</th>
                <th>discountAmountPerProduct</th>
                <th>totalDiscountAmountPerProduct</th>
                <th>totalOriginalPrice</th>
                <th>totalDiscountPrice</th>
                <c:forEach var="productDetail" items="${order.productDetails}">
                    <tr>
                        <td>${productDetail.id}</td>
                        <td>${productDetail.name}</td>
                        <td>${productDetail.weight}</td>
                        <td>${productDetail.price}</td>
                        <td>${productDetail.quantity}</td>
                        <td>${productDetail.productDiscountId}</td>
                        <td>${productDetail.discountValue}</td>
                        <td>${productDetail.discountUnit}</td>
                        <td>${productDetail.discountAmountPerProduct}</td>
                        <td>${productDetail.totalDiscountAmountPerProduct}</td>
                        <td>${productDetail.totalOriginalPrice}</td>
                        <td>${productDetail.totalDiscountPrice}</td>
                    </tr>
                </c:forEach>
            </table>
            
            <br><hr>
            <b>Total original price: ${order.totalOriginalPrice}</b><br>
            <b>Membership discount amount: -${order.membershipDiscountAmount}</b><br>
            <b>Total product discount amount: -${order.totalProductDiscountAmount}</b><br>
            <b>You saved: ${order.totalDiscountAmount}</b><br>
            <b>Total discount price: ${order.totalDiscountPrice}</b>
        </c:if>
            
        <br><hr><br>

        <sf:form action="${flowExecutionUrl}" method="post">
            <input type="submit" name="_eventId_addProduct" value="Add Product"/>
            <c:if test="${fn:length(order.productDetails) gt 0}">
                <input type="submit" name="_eventId_checkout" value="Checkout"/>
            </c:if>
            <input type="submit" name="_eventId_cancel" value="Cancel"/>
        </sf:form>
    </body>
</html>
