<%-- 
    Document   : add_deposit
    Created on : Jun 29, 2021, 10:48:54 PM
    Author     : minkes
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

            <h1 class="text-center text-light">Confirm</h1>
            <div class="d-flex col-sm-8 mx-auto my-4">
                <p class="h4 text-secondary">CUSTOMER</p>
                <p class="h4 ms-auto text-light"> ${customer.name}</p>
            </div>
            <div class="d-flex col-sm-8 mx-auto my-4">
                <p class="h4 text-secondary">DEPOSIT AMOUNT </p>
                <p class="h4 ms-auto text-light">
                    <fmt:formatNumber value="${deposit_amount}" minFractionDigits="2"/>
                </p>
            </div>
            <div class="d-flex col-sm-8 mx-auto my-4">
                <p class="h4 text-secondary">BALANCE BEFORE </p>
                <p class="h4 ms-auto text-light">
                    <fmt:formatNumber value="${customer.balance}" minFractionDigits="2"/>
                </p>
            </div>
            <div class="d-flex col-sm-8 mx-auto my-4">
                <p class="h4 text-secondary">BALANCE AFTER </p>
                <p class="h4 ms-auto text-light">
                    <fmt:formatNumber value="${customer.balance + deposit_amount}" minFractionDigits="2"/>
                </p>
            </div>
            <div class="d-flex col-sm-8 mx-auto my-4">
                <p class="h4 text-secondary">DEPOSIT DATE </p>
                <p class="h4 ms-auto text-light">${deposit_date}</p>
                <input type="hidden" value="${deposit_date}" id="input_deposit_date" name="input_deposit_date">
            </div>

            <div class="d-flex justify-content-center">
                <a class="btn btn-light mx-3" href="#" onclick="cancelClick()">Cancel</a>
                <a class="btn btn-light mx-3" href="#" onclick="saveClick()">Save</a>
            </div>
        </div>
        <form id="frm_hidden" method="get">
            <input type="hidden" id="f_customer_id" name="f_customer_id" value="">
            <input type="hidden" id="f_deposit_amount" name="f_deposit_amount" value="">
            <input type="hidden" id="f_balance_before" name="f_balance_before" value="">
            <input type="hidden" id="f_balance_after" name="f_balance_after" value="">
            <input type="hidden" id="f_deposit_date" name="f_deposit_date" value="">
        </form>
    </body>
    <script>
        function saveClick() {
            $('#f_customer_id').val(${customer.id});
            $('#f_deposit_amount').val(${deposit_amount});
            $('#f_balance_before').val(${customer.balance});
            $('#f_balance_after').val(${customer.balance + deposit_amount});
            $('#f_deposit_date').val($('#input_deposit_date').val());
            $('#frm_hidden').attr('action', './save');
            $("#frm_hidden").submit();
        }
        function cancelClick() {
            window.location.href = '../';
        }
    </script>
    <script src="../scripts/jquery-3.6.0.min.js"></script>
</html>
