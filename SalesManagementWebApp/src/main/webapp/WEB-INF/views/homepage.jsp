<%-- 
    Document   : homepage
    Created on : Jun 18, 2021, 10:52:22 AM
    Author     : leanhtai01
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <style scoped>
            .nav-link {color: white;}
            #navbar-wd {
                background: #0892fd;
                height: 119px;
                padding-right: 20px;
                border-radius: 100%;
            }
         </style>
        <title>Homepage</title>
    </head>
    <body>
         <header class="top-header">
        <nav class="navbar header-nav navbar-expand-lg">
            <div class="container-fluid">
                <a class="navbar-brand" href="javascript:;">
                    <h3 class="align-items-center"><span class="theme_color">Sales Management</h3>
                </a>
                <div class="collapse navbar-collapse justify-content-center" id="navbar-wd">
                    <ul class="navbar-nav">
                        <li><a class="nav-link" href="customer/manager">Customer</a></li>
                        <li><a class="nav-link" href="product/list">Product</a></li>
                        <li><a class="nav-link" href="discount/getlist">Discount</a></li>
                        <li><a class="nav-link" href="membershiptype/manager">Membership</a></li>
                        <li><a class="nav-link" href="productpurchase">Product Purchase</a></li>
                        <li><a class="nav-link" href="saleshistory/index">Sales History</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
    </body>
</html>
