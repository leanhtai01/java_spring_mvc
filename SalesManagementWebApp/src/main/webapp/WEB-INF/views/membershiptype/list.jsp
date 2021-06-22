<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/main.css">
        <title>Membership Type's Information</title>
    </head>
    <body>
        <table>
            <th>membership_type</th>
            <th>debt_limit</th>
            <th>discount_value</th>
            <th>discount_unit</th>
            <th>valid_from</th>
            <th>valid_util</th>

            <c:forEach var="membershipType" items="${membershipTypeList}">
                <tr>
                    <td>${membershipType.membershipType}</td>
                    <td>${membershipType.debtLimit}</td>
                    <td>${membershipType.discountValue}</td>
                    <td>${membershipType.discountUnit}</td>
                    <td>${membershipType.validFrom}</td>
                    <td>${membershipType.validUntil}</td>
                    <td><a href="edit?id=${membershipType.id}">edit</a></td>
                    <td><a href="delete?id=${membershipType.id}">delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
