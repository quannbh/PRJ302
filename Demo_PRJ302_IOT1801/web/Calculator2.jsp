<%-- 
    Document   : Calculator
    Created on : Jan 24, 2024, 11:08:15 AM
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
        <form id="frm" action="demo2" method='get'>
            Enter a:<input type='text' name='a' value="${a}"><br>
            Enter b:<input type='text' name='b' value="${b}"><br>
            Operator:
            <select name="op" onchange="execute()">
                <option value="0">All</option>
                <option value="1">UCLN</option>
                <option value="2">BCNN</option>
            </select>
            <br>
            <input type='submit' name='cong' value='a+b'>
            <input type='submit' name='tru' value='a-b'>
            <input type='submit' name='nhan' value='a*b'>
            <input type='submit' name='chia' value='a/b'><br>
            Result:<input type="text" readonly value="${result}">
        </form>
        History: 
        <table border="1">
            <tr>
                <td>a</td>
                <td>b</td>
                <td>result</td>
            </tr>
            <c:forEach items="${data}" var="item">
                <tr>
                    <td>${item.getA()}</td>
                    <td>${item.getB()}</td>
                    <td>${item.getC()}</td>
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
