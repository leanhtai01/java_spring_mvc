<%-- 
    Document   : phoneNumberCollectForm
    Created on : Jun 28, 2021, 12:33:46 PM
    Author     : leanhtai01
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enter Customer's phone number</title>
    </head>
    <body>
        <h2>Enter Customer's phone number</h2>
        <form action="${flowExecutionUrl}" method="post">
            <input type="search" name="phoneNumber" placeholder="Enter phone number"/>
            <input type="submit" name="_eventId_phoneEntered" value="Search Customer"/>
        </form>
    </body>
</html>
