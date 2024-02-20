/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import Model.Operators;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class MinMaxServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    static ArrayList<Operators> dataMin = new ArrayList<Operators>();
    static ArrayList<Operators> dataMax = new ArrayList<Operators>();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MinMaxServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MinMaxServlet at " + request.getContextPath() + "</h1>");
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
            String a = req.getParameter("a");
            String b = req.getParameter("b");
            String c = req.getParameter("c");

            String result = "";

            String checkInput = checkInput(a, b, c);
            if (!checkInput.equals("")) {
                result = checkInput;
                req.setAttribute("result", result);
                req.setAttribute("a", a);
                req.setAttribute("b", b);
                req.setAttribute("c", c);
                req.getRequestDispatcher("MinMax.jsp").forward(req, resp);
                return;
            }
            //Xử lý thông tin
            if (req.getParameter("search") != null) {
                if (req.getParameter("luaChon") != null) {
                    String luachon = req.getParameter("luaChon");
                    if (luachon.equals("max")) { //Thay đổi option kích hoạt onchange
                        int d = findMaxNumber(Integer.parseInt(a), Integer.parseInt(b), Integer.parseInt(c));
                        result = "Max: " + d;
                        dataMax.add(new Operators(a, b, c, result));
                    } else if (luachon.equals("min")) {
                        int d = findMinNumber(Integer.parseInt(a), Integer.parseInt(b), Integer.parseInt(c));
                        result = "Min: " + d;
                        dataMin.add(new Operators(a, b, c, result));
                    }
                } else {
                    result = "Please select operator.";
                }
            }

            //Trả kết quả về cho client
            //out.print(result);
            req.setAttribute("result", result);
            req.setAttribute("a", a);
            req.setAttribute("b", b);
            req.setAttribute("c", c);
            req.setAttribute("dataMin", dataMin);
            req.setAttribute("dataMax", dataMax);
            req.getRequestDispatcher("MinMax.jsp").forward(req, resp);
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

//    private String checkInput(String a, String b, boolean isDivide) {
//        if (isDivide) {
//            if (!isNumeric(b) || Double.parseDouble(b) == 0) {
//                return "Input b must be a non-zero number";
//            }
//        }
//        if (!isNumeric(a) || !isNumeric(b)) {
//            return "Both inputs must be numbers";
//        }
//
//        if (a.isEmpty()) {
//            if (b.isEmpty()) {
//                return "Both inputs are empty!";
//            }
//            return "Input a is empty!";
//        } else if (b.isEmpty()) {
//            return "Input b is empty!";
//        }
//        return "";
//    }
//
//    private boolean isNumeric(String str) {
//        if (str == null || str.trim().isEmpty()) {
//            return false;
//        }
//        try {
//            Double.parseDouble(str);
//            return true;
//        } catch (NumberFormatException e) {
//            return false;
//        }
//    }
    private int findMaxNumber(int a, int b, int c) {
        // Sử dụng toán tử ba ngôi để so sánh và trả về số lớn nhất
        int max = (a > b) ? ((a > c) ? a : c) : ((b > c) ? b : c);
        return max;
    }

    private int findMinNumber(int a, int b, int c) {
        // Sử dụng toán tử ba ngôi để so sánh và trả về số lớn nhất
        int min = (a < b) ? ((a < c) ? a : c) : ((b < c) ? b : c);
        return min;
    }

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

    private String checkInput(String a, String b, String c) {
        if (a.isEmpty() && b.isEmpty() && c.isEmpty()){
            return "Input a, b and c are empty!";
        }
        if (a.isEmpty()) {
            if (b.isEmpty()) {
                return "Input a and b are empty!";
            } else if (c.isEmpty()) {
                return "Input a and c are empty!";
            }
            return "Input a is empty!";
        } else if (b.isEmpty()) {
            if (c.isEmpty()) {
                return "Input b and c are empty!";
            }
            return "Input b is empty!";
        } else if (c.isEmpty()) {
            return "Input c is empty!";
        }

        if (!isInteger(a)) {
            return "Input a must be numbers";
        } else if (!isInteger(b)) {
            return "Input b must be numbers";
        } else if (!isInteger(c)) {
            return "Input c must be numbers";
        } else if (!isInteger(a) && !isInteger(b)) {
            return "Input a and b must be numbers";
        } else if (!isInteger(a) && !isInteger(b) && !isInteger(c)) {
            return "Input a, b and c must be numbers";
        } else if (!isInteger(a) && !isInteger(c)) {
            return "Input a and c must be numbers";
        } else if (!isInteger(b) && !isInteger(c)) {
            return "Input b and c must be numbers";
        }
        return "";
    }
}
