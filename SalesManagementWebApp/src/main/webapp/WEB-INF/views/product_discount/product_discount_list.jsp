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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <link href="../css/mint_style.css" rel="stylesheet">
        <title>Product Discount</title>
    </head>
    <body>
        <h1>All Product Discount's information</h1>
        <div style="margin: 10px 0px;">
            <form class="col-sm-4" action="./search" method="get">
                <div class="input-group">
                    <input class="form-control" id="name" name="name" type="text" placeholder="Type product name">
                    <button type="submit" class="btn btn-secondary">Search</button>
                </div>
            </form>
        </div>
        <table class="table table-hover">
            <thead>
            <th>id</th>
            <th>product</th>
            <th>discount_value</th>
            <th>discount_unit</th>
            <th>valid_from</th>
            <th>valid_until</th>
            <th></th>
            <tr>
                <td></td>
                <td>
                    <select  id="input_product_id" name="input_product_id">
                        <option selected value="" disabled>Choose Product</option>
                        <c:forEach var="product" items="${productList}">
                            <option value="${product.id}">${product.name} - ${product.weight} kg</option>
                        </c:forEach>
                    </select>
                </td>
                <td><input id="input_discount_value" name="input_discount_value" placeholder="Type discount value"></td>
                <td>
                    <select name="input_discount_unit" id="input_discount_unit">
                        <option>FLAT_CURRENCY</option>
                        <option>PERCENT</option>
                    </select>
                </td>
                <td><input id="input_valid_from" type="date"></td>
                <td><input id="input_valid_until" type="date"></td>
                <td>
                    <a href="#" onclick="addClick()">Add Row</a>
                </td>
            </tr>
        </thead>

        <c:forEach var="discount" items="${productDiscountList}">
            <c:choose>
                <c:when test="${discount.id == discount_id}">
                    <tr>
                        <td><input type="text" id="edit_id" name="edit_id" value="${discount.id}" disabled style="width: 50px;"></td>
                        <td>
                            <select id="edit_product_id" name="edit_product_id">
                                <c:forEach var="product" items="${productList}">
                                    <option value="${product.id}" 
                                            <c:if test = "${discount.product_id == product.id}">
                                                selected
                                            </c:if> value="${product.id}">
                                        ${product.name} - ${product.weight} kg
                                    </option>
                                </c:forEach>
                            </select>
                        </td>
                        <td><input type="text" id="edit_discount_value" name="edit_discount_value" value="${discount.discount_value}"></td>
                        <td>
                            <select name="edit_discount_unit" id="edit_discount_unit">
                                <c:choose>
                                    <c:when test="${discount.discount_unit == 'FLAT_CURRENCY'}">
                                        <option selected>FLAT_CURRENCY</option>
                                        <option >PERCENT</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option >FLAT_CURRENCY</option>
                                        <option selected>PERCENT</option>
                                    </c:otherwise>
                                </c:choose>
                            </select>
                        </td>
                        <td><input type="date" id="edit_valid_from" name="edit_valid_from" value="${discount.valid_from}"></td>
                        <td><input type="date" id="edit_valid_until" name="edit_valid_until" value="${discount.valid_until}"></td>
                        <td>
                            <a href="#" onclick="saveClick(${discount.id})">Save</a>
                            <a href="./getlist">Cancel</a>
                        </td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <tr>
                        <td>${discount.id}</td>
                        <td>${discount.product_name} - ${discount.product_weight} kg</td>
                        <td>${discount.discount_value}</td>
                        <td>${discount.discount_unit}</td>
                        <td>${discount.valid_from}</td>
                        <td>${discount.valid_until}</td>
                        <td>
                            <a href="#" onclick="deleteClick(${discount.id})">Delete</a>
                            <a href="#" onclick="updateClick(${discount.id})">Update</a>
                        </td>
                    </tr>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </table>
    <form id="frm_hidden" method="post">
        <input type="hidden" id="f_id" name="f_id" value="">
        <input type="hidden" id="f_product_id" name="f_product_id" value="">
        <input type="hidden" id="f_discount_value" name="f_discount_value" value="">
        <input type="hidden" id="f_discount_unit" name="f_discount_unit" value="">
        <input type="hidden" id="f_valid_from" name="f_valid_from" value="">
        <input type="hidden" id="f_valid_until" name="f_valid_until" value="">
    </form>

    <script src="../scripts/jquery-3.6.0.min.js"></script>
    <script>
        function addClick() {
            $error = "";
            $('#f_product_id').val($('#input_product_id :selected').val());
            $('#f_discount_value').val($('#input_discount_value').val());
            $('#f_discount_unit').val($('#input_discount_unit :selected').text());
            $('#f_valid_from').val($('#input_valid_from').val());
            $('#f_valid_until').val($('#input_valid_until').val());
            
            if ($('#f_product_id').val() === "") {
                $error = $error + "product must be selected \n";
            }
            if ($('#f_discount_value').val() === "") {
                $error = $error + "discount value must not be empty \n";
            } else if ($.isNumeric($('#f_discount_value').val()) === false) {
                $error = $error + "discount value must be number \n";
            }
            if ($('#f_valid_from').val() === "") {
                $error = $error + "valid from must not be empty \n";
            }
            if ($('#f_valid_until').val() === "") {
                $error = $error + "valid until must not be empty \n";
            }

            if ($error !== "") {
                alert($error);
            } else {
                $('#frm_hidden').attr('action', './add');
                $("#frm_hidden").submit();
            }
        }
        ;
        function updateClick(id) {
            $('#f_id').val(id);
            $('#frm_hidden').attr('action', './update');
            $("#frm_hidden").submit();
        }
        ;
        function saveClick() {
            $error = "";

            $('#f_id').val($('#edit_id').val());
            $('#f_product_id').val($('#edit_product_id').val());
            $('#f_discount_value').val($('#edit_discount_value').val());
            $('#f_discount_unit').val($('#edit_discount_unit :selected').text());
            $('#f_valid_from').val($('#edit_valid_from').val());
            $('#f_valid_until').val($('#edit_valid_until').val());
            
            if ($('#f_discount_value').val() === "") {
                $error = $error + "discount value must not be empty \n";
            } else if ($.isNumeric($('#f_discount_value').val()) === false) {
                $error = $error + "discount value must be number \n";
            }
            if ($('#f_valid_from').val() === "") {
                $error = $error + "valid from must not be empty \n";
            }
            if ($('#f_valid_until').val() === "") {
                $error = $error + "valid until must not be empty \n";
            }

            if ($error !== "") {
                alert($error);
            } else {
                $('#frm_hidden').attr('action', './save');
                $("#frm_hidden").submit();
            }
        }
        ;
        function deleteClick(id) {
            var r = confirm("Do you want delete it!");
            if (r === true) {
                $('#f_id').val(id);
                $('#frm_hidden').attr('action', './delete');
                $("#frm_hidden").submit();
            }
        }
        ;
    </script>
</body>
</html>
