<%-- 
    Document   : startstate
    Created on : Jun 25, 2021, 5:48:02 PM
    Author     : leanhtai01
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Start State</title>
    </head>
    <body>
        <h2>Click to go to your desired state!</h2>
        
        <form action="${flowExecutionUrl}" method="post">
            <input type="submit" name="_eventId_firststate" value="Go to First State"/>
            <input type="submit" name="_eventId_secondstate" value="Go to Second State"/>
        </form>
    </body>
</html>
