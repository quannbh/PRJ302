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
        <form action="product" method="get">
            Enter name: <input type="text" name="name" placeholder="Search by name">
            <input type="submit" value="SEARCH" name="search">
        </form>
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
                    <td><a href="product?mod=3&id=${u.getId()}">${u.getId()}</a></td>
                    <td>${u.getName()}</td>
                    <td>${u.getPrice()}</td>
                    <td>${u.getStock()}</td>
                    <td>${u.getImage()}</td>
                    <td>${u.getCategory()}</td>
                    <td><a href="product?mod=2&id=${u.getId()}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
