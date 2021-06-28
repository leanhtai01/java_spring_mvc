<%-- 
    Document   : addCustomerForm
    Created on : Jun 28, 2021, 12:39:09 PM
    Author     : leanhtai01
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add new customer</title>
    </head>
    <body>
        <h2>Add new customer</h2>
        <sf:form modelAttribute="customer">
            <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
            <sf:input type="hidden" path="id"/>
            <label>Name: <sf:input type="text" path="name"/></label><br>
            <label>Phone number: <sf:input type="text" path="phoneNumber"/></label><br>
            <label>Email: <sf:input type="email" path="email"/></label><br>
            <label>Balance: <sf:input type="text" path="balance"/></label><br>
            <sf:input type="hidden" path="membershipTypeId" value="1"/>
            <sf:input type="hidden" path="membershipType" value="garbage"/>
            <input type="submit" name="_eventId_submit" value="Add">
            <input type="submit" name="_eventId_cancel" value="cancel"/>
        </sf:form>
    </body>
</html>
