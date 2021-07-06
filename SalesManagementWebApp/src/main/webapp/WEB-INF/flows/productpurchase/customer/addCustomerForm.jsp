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
        <sf:form modelAttribute="customerAndMembershipTypeList">
            <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
            <sf:input type="hidden" path="customer.id"/>
            <label>Name: <sf:input type="text" path="customer.name"/></label><br>
            <label>Phone number: <sf:input type="text" path="customer.phoneNumber"/></label><br>
            <label>Email: <sf:input type="email" path="customer.email"/></label><br>
            <label>Balance: <sf:input type="text" path="customer.balance"/></label><br>
            <label>Membership:
                <sf:select path="customer.membershipTypeId">
                    <c:forEach var="mt" items="${customerAndMembershipTypeList.membershipTypes}">
                        <option value="${mt.id}">${mt.membershipType}</option>
                    </c:forEach>
                </sf:select>
            </label><br>
            <sf:input type="hidden" path="customer.membershipType" value="garbage"/>
            <input type="submit" name="_eventId_submit" value="Add">
            <input type="submit" name="_eventId_cancel" value="cancel"/>
        </sf:form>
    </body>
</html>
