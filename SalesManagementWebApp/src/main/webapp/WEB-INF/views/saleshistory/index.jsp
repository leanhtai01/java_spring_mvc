<%-- 
    Document   : index
    Created on : Jul 2, 2021, 6:10:01 PM
    Author     : minkes
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <link rel="stylesheet" href="../css/mint_style.css">
        <title>Sales History</title>
    </head>
    <body>
        <h1 class="text-center">Sales History</h1>
        <div class="my-4 p-2">
            <form class="d-flex col-sm-5" action="./list" method="get">
                <div class="input-group">
                    <label class="input-group-text">From Date</label>
                    <input type="date" id="f_from_date" name="f_from_date">
                </div>
                <div class="input-group">
                    <label class="input-group-text">To Date</label>
                    <input type="date" id="f_to_date" name="f_to_date">
                </div>
                <button class="btn btn-secondary">Show</button>
            </form>
        </div>
        <table class="table table-hover">
            <thead>
                <tr>
                    <th>Customer ID</th>
                    <th>Order ID</th>
                    <th>Customer Name</th>
                    <th>Total Detail</th>
                    <th>Order Date</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="history" items="${sales_history}">
                    <tr>
                        <td>${history.customer_id}</td>
                        <td>${history.order_id}</td>
                        <td>${history.customer_name}</td>
                        <td><fmt:formatNumber type="number" maxFractionDigits="3" value="${history.total_detail}" /> </td>
                        <td>${history.order_date}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
    <script src="../scripts/jquery-3.6.0.min.js"></script>
</html>
