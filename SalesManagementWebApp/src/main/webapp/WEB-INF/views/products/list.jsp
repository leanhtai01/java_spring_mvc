<%-- 
    Document   : list
    Created on : Jun 21, 2021, 10:56:30 PM
    Author     : HuuDepTrai
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/product.css">
        <title>Products</title>
        <!--<script type="text/javascript" src="../../../scripts/product.js"></script>-->
        <script>
            function handleDel(id) {
                var r = confirm(`Are you sure to delete this product! `);
                if (r == true) {
                    var xhttp = new XMLHttpRequest() || ActiveXObject();
                        xhttp.onreadystatechange = function () {
                            if (this.status == 200) {
                                window.location.href = "list";
                            }
                        }
                        xhttp.open('GET',`delete?id=` + +id,true);
                        xhttp.send();
                    }
                }
            
            function handleEdit(id) {
                window.location.href = "edit?id=" + id;
            }
        </script>
    </head>
    <body id="product">
        <body>
        <h1>Products Manager</h1>
        <form id="add" action="add">
            <button type="submit">Add</button>
        </form>
        <form id="find" action="find">
            <input type="text" name="keywords">
            <button type="submit">Find</button>
        </form>
        <c:if test = "${products.size() == 0}">
            <p style="text-align: center; margin-top: 6rem;">No Data To Show!<p>
        </c:if>
             
        <c:if test = "${products.size() != 0}">
        <table>
            <tr>
                <th>name</th>
                <th>weight</th>
                <th>price</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="product" items="${products}">
                <tr>
                    <td>${product.name}</td>
                    <td>${product.weight}</td>
                    <td>${product.price}</td>
                    <td><input type="button" onclick="handleEdit(${product.id})" value="Edit"/></td>
                    <td><input type="button" onclick="handleDel(${product.id})" value="Delete"></td>
                </tr>
            </c:forEach>
        </table>
        </c:if>
    </body>
    </body>
</html>
