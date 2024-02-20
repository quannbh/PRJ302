<%-- 
    Document   : SignUp
    Created on : Jan 30, 2024, 11:10:09 PM
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
                width: 70%;
            }
        </style>
    </head>
    <body>
        <div style="width: fit-content; border: 1px solid red; padding: 1%">
            <form id="frm" action="SignUpServlet" method='post'>
                <table style="font-weight: bold; color: blue;">
                    <tr>
                        <td colspan="2" style="color: blue;text-align: center; padding: 5% 0 3% 0"> ĐĂNG KÝ THÀNH VIÊN </td>
                    </tr>
                    <tr>
                        <td>Tên truy cập:</td> 
                        <td>
                            <input type="text" id="username" name="username" value="${username}" required> (*)
                        </td>
                    </tr>
                    <tr>
                        <td>Mật khẩu:</td> 
                        <td>
                            <input type="password" id="password" name="password" value="${password}" required> (*)
                        </td>
                    </tr>
                    <tr>
                        <td>Nhập lại mật khẩu:&emsp;</td> 
                        <td>
                            <input type="password" id="passwordRepeat" name="passwordRepeat" value="${passwordRepeat}" required> (*)
                        </td>
                    </tr>
                    <tr>
                        <td>Tên đầy đủ</td> 
                        <td>
                            <input type="text" id="displayName" name="displayName" value="${displayName}" required> (*)
                        </td>
                    </tr>
                    <tr>
                        <td>Giới tính</td> 
                        <td>
                            <select name="op">
                                <option value="women">Nữ</option>
                                <option value="men">Nam</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Email</td> 
                        <td>
                            <input type="text" id="email" name="email" value="${email}" required> (*)
                        </td>
                    </tr>
                    <tr>
                        <td>Địa chỉ</td> 
                        <td>
                            <textarea id="address" name="address" rows="3" cols="25" value="${address}"></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" style="text-align: center" value="${gender}"> 
                            <input type="submit" name="signUp" value="Đăng ký"> 
                            <input type="submit" name="xoa" value="Thoát">
                        </td>
                    </tr>
                </table>
            </form>
            Result: ${result}
            <br>
            Database:
            <table border="1">
                <tr>
                    <td>Tên truy cập</td>
                    <td>Mật khẩu</td>
                    <td>Tên đầy đủ</td>
                    <td>Giới tính</td>
                    <td>Email</td>
                    <td>Địa chỉ</td>
                </tr>
                <c:forEach items="${data}" var="item">
                    <tr>
                        <td>${item.getUsername()}</td>
                        <td>${item.getPassword()}</td>
                        <td>${item.getDisplayName()}</td>
                        <td>${item.getGender()}</td>
                        <td>${item.getEmail()}</td>
                        <td>${item.getAddress()}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
