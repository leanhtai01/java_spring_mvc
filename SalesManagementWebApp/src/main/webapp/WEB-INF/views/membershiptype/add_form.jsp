<%-- 
    Document   : add_form
    Created on : Jul 7, 2021, 12:39:25 PM
    Author     : leanhtai01
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add new Membership Type</title>
    </head>
    <body>
        <h1>Add new Membership Type:</h1>
        <form action="add" method="POST">
            <input type="hidden" name="id" value="0">
            <label>Membership Type: <input type="text" name="membershipType"></label><br>
            <label>Debt Limit: <input type="text" name="debtLimit"></label><br>
            <label>Discount Value: <input type="text" name="discountValue"></label><br>
            <label>Discount Unit:
                <select name="discountUnit">
                    <option value="PERCENT">PERCENT</option>
                    <option value="FLAT_CURRENCY">FLAT_CURRENCY</option>
                </select>
            </label><br>
            <label>Valid From: <input type="date" name="validFrom"></label><br>
            <label>Valid Until: <input type="date" name="validUntil"></label><br>
            <input type="submit" value="Add">
        </form>
    </body>
</html>
