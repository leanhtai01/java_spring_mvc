<%-- 
    Document   : product_discount_list
    Created on : Jun 21, 2021, 2:07:18 PM
    Author     : minkes
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/main.css">
        <title>Product Discount</title>
    </head>
    <body>
        <h1>All Product Discount's information</h1>
        <div style="margin: 10px 0px;">
            <form action="./search" method="get">
                <input id="name" name="name" type="text" placeholder="Type product name">
                <button>Search</button>
            </form>
        </div>
        <c:out value="${discount_id}"></c:out>
            <table>
                <th>id</th>
                <th>product_id</th>
                <th>discount_value</th>
                <th>discount_unit</th>
                <th>valid_from</th>
                <th>valid_until</th>
                <th></th>
                <c:forEach var="customer" items="${productDiscountList}">
                    <c:choose>
                        <c:when test="${customer.id == discount_id}">
                        <tr>
                            <td><input type="text" id="edit_id" name="edit_id" value="${customer.id}" disabled style="width: 50px;"></td>
                            <td><input type="text" id="edit_product_id" name="edit_product_id" value="${customer.product_id}"></td>
                            <td><input type="text" id="edit_discount_value" name="edit_discount_value" value="${customer.discount_value}"></td>
                            <td>
                                <select name="edit_discount_unit" id="edit_discount_unit">
                                    <c:choose>
                                        <c:when test="${customer.discount_unit == 'FLAT CURRENCY'}">
                                            <option selected>FLAT CURRENCY</option>
                                            <option >PERCENT</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option >FLAT CURRENCY</option>
                                            <option selected>PERCENT</option>
                                        </c:otherwise>
                                    </c:choose>
                                </select>
                            </td>
                            <td><input type="date" id="edit_valid_from" name="edit_valid_from" value="${customer.valid_from}"></td>
                            <td><input type="date" id="edit_valid_until" name="edit_valid_until" value="${customer.valid_until}"></td>
                            <td>
                                <a href="#" onclick="saveClick(${customer.id})">Save</a>
                                <a href="#" onclick="cancelClick()">Cancel</a>
                            </td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td>${customer.id}</td>
                            <td>${customer.product_id}</td>
                            <td>${customer.discount_value}</td>
                            <td>${customer.discount_unit}</td>
                            <td>${customer.valid_from}</td>
                            <td>${customer.valid_until}</td>
                            <td>
                                <a href="#" onclick="deleteClick(${customer.id})">Delete</a>
                                <a href="#" onclick="updateClick(${customer.id})">Update</a>
                            </td>
                        </tr>
                    </c:otherwise>
                </c:choose>

            </c:forEach>
            <tr>
                <td></td>
                <td><input id="input_product_id" placeholder="Type product id"></td>
                <td><input id="input_discount_value" placeholder="Type discount value"></td>
                <td>
                    <select name="input_discount_unit" id="input_discount_unit">
                        <option>FLAT CURRENCY</option>
                        <option>PERCENT</option>
                    </select>
                </td>
                <td><input id="input_valid_from" type="date"></td>
                <td><input id="input_valid_until" type="date"></td>
                <td>
                    <a href="#" onclick="addClick()">Add Row</a>
                </td>
            </tr>
        </table>
        <form id="frm_hidden" method="post">
            <input type="hidden" id="f_id" name="f_id" value="">
            <input type="hidden" id="f_product_id" name="f_product_id" value="">
            <input type="hidden" id="f_discount_value" name="f_discount_value" value="">
            <input type="hidden" id="f_discount_unit" name="f_discount_unit" value="">
            <input type="hidden" id="f_valid_from" name="f_valid_from" value="">
            <input type="hidden" id="f_valid_until" name="f_valid_until" value="">

        </form>
        <script>
            function addClick() {
                $('#f_product_id').val($('#input_product_id').val());
                $('#f_discount_value').val($('#input_discount_value').val());
                $('#f_discount_unit').val($('#input_discount_unit :selected').text());
                $('#f_valid_from').val($('#input_valid_from').val());
                $('#f_valid_until').val($('#input_valid_until').val());
                $('#frm_hidden').attr('action', './add');
                $("#frm_hidden").submit();
            }
            ;
            function updateClick(id) {
                $('#f_id').val(id);
                $('#frm_hidden').attr('action', './update');
                $("#frm_hidden").submit();
            }
            ;
            function saveClick() {
                $('#f_id').val($('#edit_id').val());
                $('#f_product_id').val($('#edit_product_id').val());
                $('#f_discount_value').val($('#edit_discount_value').val());
                $('#f_discount_unit').val($('#edit_discount_unit :selected').text());
                $('#f_valid_from').val($('#edit_valid_from').val());
                $('#f_valid_until').val($('#edit_valid_until').val());
                $('#frm_hidden').attr('action', './save');
                $("#frm_hidden").submit();
            }
            ;
            function cancelClick() {
                window.location.href='./getlist';
            }
            ;
            function deleteClick(id) {
                $('#f_id').val(id);
                $('#frm_hidden').attr('action', './delete');
                $("#frm_hidden").submit();
            }
            ;
        </script>
        <script src="../scripts/jquery-3.6.0.min.js"></script>

    </body>

</html>
