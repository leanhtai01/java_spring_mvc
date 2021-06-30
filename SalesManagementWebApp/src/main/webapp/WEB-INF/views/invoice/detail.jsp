<%-- 
    Document   : detail
    Created on : Jun 28, 2021, 3:14:04 AM
    Author     : HuuDepTrai
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <link rel="stylesheet" href="../css/invoice.css">
        <title>Invoice</title>
    </head>
    <body>
        <h1>Invoice Info</h1>
        
        <section id="first">
            <div class="row">
                <div class="col-sm" style="border-right: 1px solid #cccccc;">
                    <p><b>INVOICE: ${invoice.id}</b></p>
                    <span><b>INVOICE DATE: ${invoice.order_date}</b></span>
                </div>
                <div class="col-sm">
                    <h5><b>CUSTOMER</b></h5>
                    <div>Customer: ${invoice.customer.name}</div>
                    <div>Phone Number: ${invoice.customer.phoneNumber}</div>
                    <div>Email: ${invoice.customer.email}</div>
                </div>
            </div>
        </section>
        
                
                <section id="second">
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>NO</th>
                                <th>PRODUCT NAME</th>
                                <th>WEIGHT</th>
                                <th>PRICE</th>
                                <th>QUANTITY</th>
                                <th>DISCOUNT</th>
                                <th>AMOUNT</th>
                            </tr>
                        </thead>
                        <tbody>
                             <c:forEach var="detail" items="${invoice.orderDetail}" varStatus="loop">
                                <tr>
                                    <td>${loop.index + 1}</td>
                                    <td>${detail.product.name}</td>
                                    <td>${detail.product.weight}</td>
                                    <td>${detail.product.price}</td>
                                    <td>${detail.quantity}</td>
                                    <td>
                                        ${detail.discount_value} ${detail.discount_unit_display}</td>
                                    <td>
                                        <i><s>${detail.priceOrigin} VND</s></i>
                                        <br>
                                        ${detail.amount} VND
                                    </td>
                                </tr>
                            </c:forEach>
                                <tr>
                                    <td colspan="5"></td>
                                    <td>
                                        <b>
                                            SUB TOTAL:
                                        </b>
                                    </td>
                                    <td>${invoice.subTotal} VND</td>
                                </tr>
                                <tr>
                                    <td colspan="5"></td>
                                    <td>
                                        <b>
                                            DISCOUNT:
                                        </b>
                                        <c:if test = "${invoice.discount_unit_display == '%'}">
                                            <i>(${invoice.discount_value} ${invoice.discount_unit_display})</i>
                                        </c:if>
                                    </td>
                                    <td>${invoice.priceDiscount} VND</td>
                                </tr>
                                <tr>
                                    <td colspan="5"></td>
                                    <td>
                                        <b>
                                            TOTAL AMOUNT:
                                        </b>
                                    </td>
                                    <td>${invoice.amount} VND</td>
                                </tr>
                        </tbody>
                    </table>
                </section>
        
    </body>
</html>
