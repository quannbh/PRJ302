<%-- 
    Document   : MinMax
    Created on : Jan 24, 2024, 11:55:46 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    <%
        String a = "";
        String b = "";
        String c = "";
        String result = "";
        
        if(request.getAttribute("result") != null){
            result = (String)request.getAttribute("result");
        }
        if(request.getAttribute("a") != null){
            a = (String)request.getAttribute("a");
        }
        if(request.getAttribute("b") != null){
            b = (String)request.getAttribute("b");
        }
        if(request.getAttribute("c") != null){
            c = (String)request.getAttribute("c");
        }
    
    %>
    <body>
        <div style="width:fit-content; border: 1px solid blue; padding: 2%">
            <form action="FindMinMax" method='post'>
                <table style="font-weight: bold;">
                    <tr>
                        <td colspan="2" style="color: blue;text-align: center; padding: 5% 0 7% 0"> TÌM MAX VÀ TÌM MIN </td>
                    </tr>
                    <tr>
                        <td>Nhập a:</td> 
                        <td>
                            <input type="text" id="a" name="a" value="<%=a%>">
                        </td>
                    </tr>
                    <tr>
                        <td>Nhập b:</td> 
                        <td>
                            <input type="text" id="b" name="b" value="<%=b%>">
                        </td>
                    </tr>
                    <tr>
                        <td>Nhập c:</td> 
                        <td>
                            <input type="text" id="c" name="c" value="<%=c%>">
                        </td>
                    </tr>
                    <tr>
                        <td>Kết quả: </td> 
                        <td>
                            <input type="text" readonly id="ketQua" name="ketQua" value="<%=result%>">
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
                            <input style="margin: 7% 0 10% 0;" type="submit" name="tim" value="Tìm">
                            <input type="submit" name="xoa" value="Xóa">
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
