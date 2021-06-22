<%-- 
    Document   : add_form
    Created on : Jun 22, 2021, 9:54:50 AM
    Author     : leanhtai01
--%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add new customer</title>
    </head>
    <body>
        <form action="add" method="POST">
            <input type="hidden" name="id" value="0">
            <label>Name: <input type="text" name="name"></label><br>
            <label>Phone number: <input type="text" name="phoneNumber"></label><br>
            <label>Email: <input type="email" name="email"></label><br>
            <label>Balance: <input type="text" name="balance"></label><br>
            <label>Membership:
                <select name="membershipTypeId">
                    <option value="1">basic</option>
                    <option value="2">gold</option>
                    <option value="3">platinum</option>
                </select>
            </label><br>
            <input type="hidden" name="membershipType" value="garbage">
            <input type="submit" value="Add">
        </form>
    </body>
</html>
