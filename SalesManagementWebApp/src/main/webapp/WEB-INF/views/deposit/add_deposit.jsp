<%-- 
    Document   : add_deposit
    Created on : Jun 29, 2021, 10:48:54 PM
    Author     : minkes
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <link <link href="../css/mint_style.css" rel="stylesheet">
        <title>Deposit</title>
    </head>
    <body>
        <div class="col-sm-6 mx-auto p-5 border border-dark rounded" style="background: #1D3557">
            <h1 class="text-center text-light">Add Deposit</h1>
            <div class="input-group my-4">
                <label class="input-group-text">Customer: </label>
                <select class="form-select" id="input_customer">
                    <option selected disabled>Choose customer</option>
                    <c:forEach var="customer" items="${list_customer}">
                        <option value="${customer.id}">${customer.name} - ${customer.phoneNumber}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="input-group my-4">
                <label class="input-group-text">Deposit Amount: </label>
                <input class="form-control" type="text" placeholder="Type deposit amount" id="input_deposit_amount">
            </div>
            <div class="input-group my-4">
                <label class="input-group-text">Deposit Date: </label>
                <input class="" type="date" id="input_deposit_date">
            </div>
            <div class="d-flex my-4">
                <div class="mx-auto">
                    <a class="btn btn-outline-light mx-2" href="#" onclick="cancelClick()">Cancel</a>
                    <a class="btn btn-outline-light mx-2" href="#" onclick="nextClick()">Next</a>
                </div>
            </div>
        </div>
        <form id="frm_hidden" method="get">
            <input type="hidden" id="f_customer_id" name="f_customer_id" value="">
            <input type="hidden" id="f_deposit_amount" name="f_deposit_amount" value="">
            <input type="hidden" id="f_deposit_date" name="f_deposit_date" value="">
        </form>
    </body>
    <script>
        function nextClick() {
            $('#f_customer_id').val($('#input_customer :selected').val());
            $('#f_deposit_amount').val($('#input_deposit_amount').val());
            $('#f_deposit_date').val($('#input_deposit_date').val());
            $('#frm_hidden').attr('action', './submit');
            $("#frm_hidden").submit();
        }
        function cancelClick() {
            window.location.href = '../';
        }
    </script>
    <script src="../scripts/jquery-3.6.0.min.js"></script>
</html>
