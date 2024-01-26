<%-- 
    Document   : Example
    Created on : Jan 24, 2024, 10:14:03 AM
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
        <% 
            //Scriptlet là nơi viết code Java, run xử lý chính
            String message = "Hello Scriptlet!";
//            out.print(message);
            
            //Khai báo và khởi tạo 2 biến số nguyên a và b
            int a = 4, b = 6;
            
            //Hiển thị các phép tính cộng, trừ, nhân, chia các số nguyên a và b
//            out.print("<br> a + b = " + (a + b));
//            out.print("<br> a + b = " + (a - b));
//            out.print("<br> a + b = " + (a * b));
//            out.print("<br> a + b = " + (a / b));
            
            //Tạo hàm tìm UCLN của 2 số nguyên
            //Sử dụng hàm trên để in ra UCLN của a và b
//            out.print("<br> UCLN = " + (UCLN(a, b)));
        %>
        <%!
            //Nơi khai báo các thành phần global
            String message = "Hello JSP!";
            public int UCLN(int a, int b){
                while(a != b){
                if(a > b){
                    a = a - b;
                } else {
                    b = b - a;
                }
                }
                return a;
                }
        %>
        a = <%=a%>
        <br>b = <%=b%>
        <br>a + b = <%=a+b%>
        <br>a - b = <%=a-b%>
        <br>a * b = <%=a*b%>
        <br>a / b = <%=a/b%>
        <br>UCLN = <%=UCLN(a,b)%>
    </body>
</html>
