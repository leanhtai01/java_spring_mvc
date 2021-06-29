<%-- 
    Document   : addProduct
    Created on : Jun 29, 2021, 9:00:56 AM
    Author     : leanhtai01
--%>

<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Product to Order</title>
    </head>
    <body>
        <h2>Add Product to Order</h2>
        <sf:form action="${flowExecutionUrl}" method="post">
            <input type="submit" name="_eventId_cancel" value="Cancel"/>
        </sf:form>
    </body>
</html>
