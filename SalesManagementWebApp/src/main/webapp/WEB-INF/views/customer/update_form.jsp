<%-- 
    Document   : update_form
    Created on : Jun 22, 2021, 4:25:45 PM
    Author     : leanhtai01
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Customer</title>
    </head>
    <body>
        <h1>Update Customer:</h1>
        <sf:form action="update" method="POST" modelAttribute="customer">
            <sf:input type="hidden" path="id"/>
            <label>Name: <sf:input type="text" path="name"/></label><br>
            <label>Phone number: <sf:input type="text" path="phoneNumber"/></label><br>
            <label>Email: <sf:input type="email" path="email"/></label><br>
            <label>Balance: <sf:input type="text" path="balance"/></label><br>
            <label>Membership:
                <select name="membershipTypeId">
                    <c:forEach var="mt" items="${membershipTypeList}">
                        <option value="${mt.id}">${mt.membershipType}</option>
                    </c:forEach>
                </select>
            </label><br>
            <input type="submit" value="Update">
        </sf:form>
    </body>
</html>
