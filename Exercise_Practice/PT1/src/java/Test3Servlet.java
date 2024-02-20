/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
public class Test3Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Test3Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Test3Servlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            //Nhận thông tin từ client
            String n = req.getParameter("n");
            String textarea1 = req.getParameter("textarea1");
            String result = "";
            String sum = "";

            //Xử lý thông tin
            if (req.getParameter("reset") != null) {
                n = "";
                textarea1 = "";
            }

            if (req.getParameter("okButton") != null) {
                if (!checkInput(n).equals("")) {
                    result = checkInput(n);
                    n = "";
                } else {
                    textarea1 = evenNumbersString(Integer.parseInt(n));
                    int val = sumOfEvenNumbers(Integer.parseInt(n));
                    sum = Integer.toString(val);
                }
            }

            if (req.getParameter("show") != null) {
                if (!checkInput(n).equals("")) {
                    result = checkInput(n);
                    n = "";
                } else {
                    textarea1 = evenNumbersString(Integer.parseInt(n));
                    int val = sumOfEvenNumbers(Integer.parseInt(n));
                    sum = Integer.toString(val);
                }
                out.print("Input: " + n);
                out.print("<br>");
                out.print("Even number: " + textarea1);
                out.print("<br>");
                out.print("Sum: " + sum);
                out.print("<br>");
                out.print(result);
                return;
            }
            //Trả kết quả về cho client
            //out.print(result);
            req.setAttribute("n", n);
            req.setAttribute("sum", sum);
            req.setAttribute("textarea1", textarea1);
            req.setAttribute("result", result);

            req.getRequestDispatcher("Test3.jsp").forward(req, resp);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private boolean isInteger(String str) {
        if (str == null || str.trim().isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private String checkInput(String a) {
        int intValue = Integer.parseInt(a);
        if (intValue <= 3) {
            return "Input must be greater than 3";
        }
        if (!isInteger(a)) {
            return "Input a must be numbers";
        }
        if (a.isEmpty()) {
            return "Input is empty!";
        }
        return "";
    }

    public static String evenNumbersString(int n) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i += 2) {
            result.append(i).append(" ");
        }
        return result.toString().trim();
    }

    public static int sumOfEvenNumbers(int n) {
        int sum = 0;
        for (int i = 0; i < n; i += 2) {
            sum += i;
        }
        return sum;
    }
}
