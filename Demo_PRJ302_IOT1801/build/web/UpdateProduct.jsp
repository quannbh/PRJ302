<%-- 
    Document   : AddUsers
    Created on : Feb 21, 2024, 11:41:48 AM
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
        <form action="product" method="post">
            ID:<input type="text" name="id" value="${p.getId()}"> <br>
            Name:<input type="text" name="name" value="${p.getName()}"> <br>
            Price:<input type="text" name="price" value="${p.getPrice()}"> <br>
            Stock:<input type="text" name="stock" value="${p.getStock()}"> <br>
            Image:<input type="text" name="image" value="${p.getImage()}"> <br>
            Category:
            <select name="category">
                <c:forEach items="${data1}" var="c">
                    <c:choose>
                        <c:when test="${p.getCategory()==c.getId()}">
                            <option value="${c.getId()}" selected>${c.getName()}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${c.getId()}">${c.getName()}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select><br>
            <input type="submit" name="update" value="UPDATE">
        </form>
    </body>
</html>
