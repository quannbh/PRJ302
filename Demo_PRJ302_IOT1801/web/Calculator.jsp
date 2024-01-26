<%-- 
    Document   : Calculator
    Created on : Jan 24, 2024, 11:08:15 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Operators"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        //Nhận kết quả trả về từ servlet
        String result = "";
        if(request.getAttribute("result") != null){
            result = (String)request.getAttribute("result");
        }
        
        String a = "";
        if(request.getAttribute("a") != null){
            a = (String)request.getAttribute("a");
        }
        
        String b = "";
        if(request.getAttribute("b") != null){
            b = (String)request.getAttribute("b");
        }
        
        ArrayList<Operators> data = new ArrayList<Operators>();
        if(request.getAttribute("data") != null){
            data = (ArrayList<Operators>)request.getAttribute("data");
        }
    %>
    <body>
        <form id="frm" action="demo2" method='post'>
            Enter a:<input type='text' name='a' value="<%=a%>"><br>
            Enter b:<input type='text' name='b' value="<%=b%>"><br>
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
            Result:<input type="text" readonly value='<%=result%>'>
        </form>
        History: 
        <table border="1">
            <tr>
                <td>a</td>
                <td>b</td>
                <td>result</td>
            </tr>
            <%
                for(Operators item : data){
                    out.print("<tr>");
                    out.print("<td>" + item.getA() + "</td>");
                    out.print("<td>" + item.getB() + "</td>");
                    out.print("<td>" + item.getC() + "</td>");
                    out.print("</tr>");
                }
            %>
        </table>
        <script>
            function execute() {
                //Đơn giản chỉ để kích hoạt submit
                document.getElementById("frm").submit();
            }
        </script>
    </body>
</html>
