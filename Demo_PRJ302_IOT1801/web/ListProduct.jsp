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
        <br>
        <a href="product?mod=1">Create new product</a>
        <br><!-- comment -->
        <table border="1">
            <tr>
                <td>ID</td>
                <td>Name</td>
                <td>Price</td>
                <td>Stock</td>
                <td>Image</td>
                <td>Category</td>
            </tr>
            <c:forEach items="${data}" var="u">
                <tr>
                    <td>${u.getId()}</td>
                    <td>${u.getName()}</td>
                    <td>${u.getPrice()}</td>
                    <td>${u.getStock()}</td>
                    <td>${u.getImage()}</td>
                    <td>${u.getCategory()}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
