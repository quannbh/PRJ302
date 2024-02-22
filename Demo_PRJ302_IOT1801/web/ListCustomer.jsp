<%-- 
    Document   : ListCustomer
    Created on : Feb 22, 2024, 8:53:29 AM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>List customer</h1>
        <table border="1">
            <tr>
                <td>ID</td>
                <td>Customer name</td>
                <td>Gender</td>
                <td>Address</td>
                <td>DOB</td>
            </tr>
            <c:forEach items="${data}" var="c">
                <tr>
                    <td>${c.getCustomerID()}</td>
                    <td>${c.getCustomerName()}</td>
                    <td>${c.getGender()}</td>
                    <td>${c.getAddress()}</td>
                    <td>${c.getDob()}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
