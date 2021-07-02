<%-- 
    Document   : success
    Created on : Jun 30, 2021, 12:21:14 AM
    Author     : minkes
--%>

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
            <h1 class="text-light my-4">Success!</h1>
            <a class="btn btn-light" href="../">Go homepage</a>
            <a class="btn btn-light" href="./print?id=${customer_id}">Print</a>
        </div>
    </body>
</html>
