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
                    <span>Customer: ${invoice.customer.name}</span>
                    <span>Phone Number: ${invoice.customer.phoneNumber}</span>
                    <span>Email: ${invoice.customer.email}</span>
                </div>
            </div>
        </section>
        
        
    </body>
</html>
