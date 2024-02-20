<%-- 
    Document   : MinMax
    Created on : Jan 30, 2024, 9:36:27 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            #a,#b,#c,#ketQua {
                background-color: lightcyan;
                width: 70%
            }
        </style>
    </head>
    <body>
        <div style="width: fit-content; border: 1px solid blue; padding: 2%">
            <form id="frm" action="MinMaxServlet" method='post'>
                <table style="font-weight: bold;">
                    <tr>
                        <td colspan="2" style="color: blue;text-align: center; padding: 5% 0 7% 0"> TÌM MAX VÀ TÌM MIN </td>
                    </tr>
                    <tr>
                        <td>Nhập a:</td> 
                        <td>
                            <input type="text" id="a" name="a" value="${a}">
                        </td>
                    </tr>
                    <tr>
                        <td>Nhập b:</td> 
                        <td>
                            <input type="text" id="b" name="b" value="${b}">
                        </td>
                    </tr>
                    <tr>
                        <td>Nhập c:</td> 
                        <td>
                            <input type="text" id="c" name="c" value="${c}">
                        </td>
                    </tr>
                    <tr>
                        <td>Kết quả: </td> 
                        <td>
                            <input type="text" readonly value="${result}">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"> 
                            <input type="radio" name="luaChon" value="max">
                            <label for="option1" style="font-style: italic;">Tìm số lớn nhất</label>
                            <input style="margin: 7% 0 0 0;" type="radio" name="luaChon" value="min">
                            <label for="option2" style="font-style: italic;">Tìm số nhỏ nhất</label>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td> 
                            <input style="margin: 7% 0 10% 0;" type="submit" name="search" value="Tìm"> 
                            <input type="submit" name="xoa" value="Xóa">
                        </td>
                    </tr>
                </table>
            </form>
            History Min:
            <table border="1">
                <tr>
                    <td>a</td>
                    <td>b</td>
                    <td>c</td>
                    <td>result</td>
                </tr>
                <c:forEach items="${dataMin}" var="item">
                    <tr>
                        <td>${item.getA()}</td>
                        <td>${item.getB()}</td>
                        <td>${item.getC()}</td>
                        <td>${item.getD()}</td>
                    </tr>
                </c:forEach>
            </table>
            <br><br>
            History Max:
            <table border="1">
                <tr>
                    <td>a</td>
                    <td>b</td>
                    <td>c</td>
                    <td>result</td>
                </tr>
                <c:forEach items="${dataMax}" var="item">
                    <tr>
                        <td>${item.getA()}</td>
                        <td>${item.getB()}</td>
                        <td>${item.getC()}</td>
                        <td>${item.getD()}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
