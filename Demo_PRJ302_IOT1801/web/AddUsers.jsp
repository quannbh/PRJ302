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
        <form action="user" method="get">
            Account:<input type="text" name="account"> <br>
            Password:<input type="text" name="password"> <br>
            Name:<input type="text" name="name"> <br>
            Gender:<input type="radio" name="gender" value="1"> Male
            <input type="radio" name="gender" value="0"> Female <br>
            Address:<input type="text" name="address"> <br>
            DOB:<input type="date" name="dob"> <br>
            <input type="submit" name="register" value="REGISTER">
        </form>
    </body>
</html>
<!-- customer để tạo ra danh sách các customer, tạo thêm customer controller nữa -->
