<%-- 
    Document   : errorDuplicateEmail
    Created on : Jun 28, 2021, 11:15:22 PM
    Author     : leanhtai01
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error! Email already exists!</title>
    </head>
    <body>
        <h2>Error! Email already exists!</h2>
        <form action="${flowExecutionUrl}" method="post">
            <input type="submit" name="_eventId_tryagain" value="Try Again">
            <input type="submit" name="_eventId_cancel" value="Cancel"/>
        </form>
    </body>
</html>
