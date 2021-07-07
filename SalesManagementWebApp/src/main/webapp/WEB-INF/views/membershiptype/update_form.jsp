<%-- 
    Document   : update_form
    Created on : Jul 7, 2021, 1:51:17 PM
    Author     : leanhtai01
--%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Membership Type</title>
    </head>
    <body>
        <h1>Update Membership Type</h1>
        <sf:form action="update" method="POST" modelAttribute="membershipType">
            <sf:input type="hidden" path="id"/>
            <label>Membership Type: <sf:input type="text" path="membershipType"/></label><br>
            <label>Debt Limit: <sf:input type="text" path="debtLimit"/></label><br>
            <label>Discount Value: <sf:input type="text" path="discountValue"/></label><br>
            <label>Discount Unit:
                <sf:select path="discountUnit">
                    <option value="PERCENT">PERCENT</option>
                    <option value="FLAT_CURRENCY">FLAT_CURRENCY</option>
                </sf:select>
            </label><br>
            <label>Valid From: <sf:input type="date" path="validFrom"/></label><br>
            <label>Valid Until: <sf:input type="date" path="validUntil"/></label><br>
            <input type="submit" value="Update">
        </sf:form>
    </body>
</html>
