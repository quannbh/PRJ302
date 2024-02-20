/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import Model.UserInformation;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ADMIN
 */
public class SignUpServlet extends HttpServlet {

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
            out.println("<title>Servlet SignUpServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SignUpServlet at " + request.getContextPath() + "</h1>");
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
    static ArrayList<UserInformation> data = new ArrayList<UserInformation>();

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
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String passwordRepeat = req.getParameter("passwordRepeat");
            String displayName = req.getParameter("displayName");
            String gender = "";
            String email = req.getParameter("email");
            String address = req.getParameter("address");
            if (req.getParameter("op").equals("women")) {
                gender = "women";
            } else if (req.getParameter("op").equals("men")) {
                gender = "men";
            }

            boolean status = false;
            String result = "";

            //Xử lý thông tin
            if (req.getParameter("signUp") != null) {
                if (!kiemTraUsername(username)) {
                    result = "Sign up failed. Username must be up to 8 characters.";
                } else if (!password.equals(passwordRepeat)) {
                    result = "Sign up failed. Passwords do not match.";
                } else if (!kiemTraEmail(email)) {
                    result = "Sign up failed. Invalid email format.";
                } else {
                    result = "Sign up successful!";
                    status = true;
                }

                if (status == false) {
                    req.setAttribute("result", result);
                    req.setAttribute("username", username);
                    req.setAttribute("password", password);
                    req.setAttribute("passwordRepeat", passwordRepeat);
                    req.setAttribute("displayName", displayName);
                    req.setAttribute("email", email);
                    req.setAttribute("address", address);
                    req.getRequestDispatcher("SignUp.jsp").forward(req, resp);
                    return;
                }

                data.add(new UserInformation(username, password, displayName, gender, email, address));

                //Trả kết quả về cho client
                //out.print(result);
                req.setAttribute("result", result);
                req.setAttribute("data", data);
                req.getRequestDispatcher("SignUp.jsp").forward(req, resp);
            }
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

    public static boolean kiemTraEmail(String email) {
        // Biểu thức chính quy để kiểm tra địa chỉ email
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    public static boolean kiemTraUsername(String username) {
        // Biểu thức chính quy để kiểm tra tên người dùng có tối đa 8 ký tự
        String regex = "^[a-zA-Z0-9]{1,8}$";

        return username.matches(regex);
    }
}
