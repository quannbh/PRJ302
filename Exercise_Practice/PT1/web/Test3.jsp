<%-- 
    Document   : Test3
    Created on : Jan 31, 2024, 10:09:11 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            #a,#b,#c,#ketQua {
                width: 70%
            }
        </style>
    </head>
    <body>
        <div style="width: fit-content; border: 2px solid orange; padding: 2%">
            <form id="frm" action="Test3Servlet" method='post'>
                <table style="font-weight: bold;">
                    <tr>
                        <td colspan="2" style="color: blue;text-align: center;">TEST 3</td>
                    </tr>
                    <tr>
                        <td>Enter an integer n:
                            <br>
                            <input style="width: 50%" type="text" id="n" name="n" value="${n}">
                            <input style="margin: 5% 0 10% 0;" type="submit" name="okButton" value=">>">
                            <br>
                            <input type="submit" style="color: red; font-weight: bold; margin: 0 0 0 10%" name="reset" value="RESET"> 
                            <input type="submit" style="color: blue; font-weight: bold;" name="show" value="SHOW"></td>
                        <td>
                            <textarea id="textarea1" name="textarea1" rows="10" cols="12">
                                <c:out value="${textarea1}" />
                            </textarea>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Sum of number list:
                        </td>
                        <td>
                            <input style="width: 80%" type="text" id="sum" name="sum" value="${sum}">
                        </td>
                    </tr>
                </table>
                ${result}
            </form>
        </div>
    </body>
</html>
