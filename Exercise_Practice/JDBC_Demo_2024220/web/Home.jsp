<%-- 
    Document   : Home
    Created on : Feb 21, 2024, 12:04:44 AM
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
        <table border="1">
            <tr>
                <td>STT</td>
                <td>Họ và tên</td>
                <td>Lớp</td>
                <td>Điểm số</td>
            </tr>
            <c:forEach items="${data}" var="item" varStatus="loop">
                <tr>
                    <td>${loop.index + 1}</td> <!-- Số thứ tự -->
                    <td>${item.getName()}</td>
                    <td>${item.getClasses()}</td>
                    <td>${item.getMark()}</td>
                </tr>
            </c:forEach>
        </table>
        <script>
            function execute() {
                //Đơn giản chỉ để kích hoạt submit
                document.getElementById("frm").submit();
            }
        </script>
    </body>
</html>
