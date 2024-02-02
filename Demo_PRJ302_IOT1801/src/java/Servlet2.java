/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import Models.Operators;
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
public class Servlet2 extends HttpServlet {

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
            out.println("<title>Servlet Servlet2</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servlet2 at " + request.getContextPath() + "</h1>");
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
    static ArrayList<Operators> data = new ArrayList<Operators>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            //Nhận thông tin từ client
            String a = req.getParameter("a");
            String b = req.getParameter("b");

            if (req.getParameter("chia") != null) {
                String checkInput = checkInput(a, b, true);
                if (!checkInput.equals("")) {
                    out.print(checkInput);
                    return;
                }
            }
            String checkInput = checkInput(a, b, false);
            if (!checkInput.equals("")) {
                out.print(checkInput);
                return;
            }
            //Xử lý thông tin
            String result = "";
            boolean btn = false;
            if (req.getParameter("cong") != null) { //Mày nhấn nút a + b
                int c = Integer.parseInt(a) + Integer.parseInt(b);
                result = "a + b = " + c;
                btn = true;
            }
            if (req.getParameter("tru") != null) { //Mày nhấn nút a - b
                int c = Integer.parseInt(a) - Integer.parseInt(b);
                result = "a - b = " + c;
                btn = true;
            }
            if (req.getParameter("nhan") != null) { //Mày nhấn nút a * b
                int c = Integer.parseInt(a) * Integer.parseInt(b);
                result = "a * b = " + c;
                btn = true;
            }
            if (req.getParameter("chia") != null) { //Mày nhấn nút a / b
                double c = Double.parseDouble(a) / Double.parseDouble(b);
                result = "a / b = " + c;
                btn = true;
            }

            if (!btn) {
                if (req.getParameter("op").equals("0")) { //Thay đổi option kích hoạt onchange
                    result = "Please select option!";
                }
                if (req.getParameter("op").equals("1")) { //Thay đổi option kích hoạt onchange
                    result = "UCLN = " + UCLN(Integer.parseInt(a), Integer.parseInt(b));
                }
                if (req.getParameter("op").equals("2")) { //Thay đổi option kích hoạt onchange
                    result = "BCNN = " + BCNN(Integer.parseInt(a), Integer.parseInt(b));
                }
            }
            //Tạo 1 list Operators

            data.add(new Operators(a, b, result));

            //Trả kết quả về cho client
            //out.print(result);
            req.setAttribute("result", result);
            req.setAttribute("a", a);
            req.setAttribute("b", b);
            req.setAttribute("data", data);
            req.getRequestDispatcher("Calculator2.jsp").forward(req, resp);
        }

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

            if (req.getParameter("chia") != null) {
                String checkInput = checkInput(a, b, true);
                if (!checkInput.equals("")) {
                    out.print(checkInput);
                    return;
                }
            }
            String checkInput = checkInput(a, b, false);
            if (!checkInput.equals("")) {
                out.print(checkInput);
                return;
            }
            //Xử lý thông tin
            String result = "";
            boolean btn = false;
            if (req.getParameter("cong") != null) { //Mày nhấn nút a + b
                int c = Integer.parseInt(a) + Integer.parseInt(b);
                result = "a + b = " + c;
                btn = true;
            }
            if (req.getParameter("tru") != null) { //Mày nhấn nút a - b
                int c = Integer.parseInt(a) - Integer.parseInt(b);
                result = "a - b = " + c;
                btn = true;
            }
            if (req.getParameter("nhan") != null) { //Mày nhấn nút a * b
                int c = Integer.parseInt(a) * Integer.parseInt(b);
                result = "a * b = " + c;
                btn = true;
            }
            if (req.getParameter("chia") != null) { //Mày nhấn nút a / b
                double c = Double.parseDouble(a) / Double.parseDouble(b);
                result = "a / b = " + c;
                btn = true;
            }

            if (!btn) {
                if (req.getParameter("op").equals("0")) { //Thay đổi option kích hoạt onchange
                    result = "Please select option!";
                }
                if (req.getParameter("op").equals("1")) { //Thay đổi option kích hoạt onchange
                    result = "UCLN = " + UCLN(Integer.parseInt(a), Integer.parseInt(b));
                }
                if (req.getParameter("op").equals("2")) { //Thay đổi option kích hoạt onchange
                    result = "BCNN = " + BCNN(Integer.parseInt(a), Integer.parseInt(b));
                }
            }
            //Tạo 1 list Operators

            data.add(new Operators(a, b, result));

            //Trả kết quả về cho client
            //out.print(result);
            req.setAttribute("result", result);
            req.setAttribute("a", a);
            req.setAttribute("b", b);
            req.setAttribute("data", data);
            req.getRequestDispatcher("Calculator.jsp").forward(req, resp);
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

    private String checkInput(String a, String b, boolean isDivide) {
        if (isDivide) {
            if (!isNumeric(b) || Double.parseDouble(b) == 0) {
                return "Input b must be a non-zero number";
            }
        }
        if (!isNumeric(a) || !isNumeric(b)) {
            return "Both inputs must be numbers";
        }

        if (a.isEmpty()) {
            if (b.isEmpty()) {
                return "Both inputs are empty!";
            }
            return "Input a is empty!";
        } else if (b.isEmpty()) {
            return "Input b is empty!";
        }
        return "";
    }

    private boolean isNumeric(String str) {
        if (str == null || str.trim().isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private int UCLN(int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

    private int BCNN(int a, int b) {
        int result = UCLN(a, b);
        return a * b / result;
    }
}
