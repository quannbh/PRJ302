<%-- 
    Document   : ListUser
    Created on : Feb 2, 2024, 9:23:07 AM
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
        <h1>Login success!</h1>
        Hello ${name}
        <br>
        <a href="AddUsers.jsp">Create user</a>
        <br><!-- comment -->
        <form action="customer" method="get">
            <input type="submit" value="Customer List">
        </form>
        <table border="1">
            <tr>
                <td>Account</td>
                <td>Password</td>
                <td>Name</td>
                <td>Gender</td>
                <td>Address</td>
                <td>DOB</td>
            </tr>
            <c:forEach items="${data}" var="u">
                <tr>
                    <td>${u.getAccount()}</td>
                    <td>${u.getPassword()}</td>
                    <td>${u.getName()}</td>
                    <td>${u.getGender()}</td>
                    <td>${u.getAddress()}</td>
                    <td>${u.getDob()}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
