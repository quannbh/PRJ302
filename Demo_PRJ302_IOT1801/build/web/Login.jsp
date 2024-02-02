<%-- 
    Document   : Login
    Created on : Feb 2, 2024, 8:18:47 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="user" method="post">
            Account:<input type="text" name="account"/> <br>
            Password:<input type="text" name="password"/> <br>
            <input type="submit" name="login" value="LOGIN"/>
        </form>
    </body>
</html>
