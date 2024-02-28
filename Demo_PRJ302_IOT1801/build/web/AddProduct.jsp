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
            Name:<input type="text" name="name"> <br>
            Price:<input type="text" name="price"> <br>
            Stock:<input type="text" name="stock"> <br>
            Image:<input type="text" name="image"> <br>
            Category:
            <select name="category">
                <c:forEach items="${data1}" var="c">
                    <option value="${c.getId()}">${c.getName()}</option>
                </c:forEach>
            </select><br>
            <input type="submit" name="add" value="ADD">
        </form>
    </body>
</html>
<!-- customer để tạo ra danh sách các customer, tạo thêm customer controller nữa -->
