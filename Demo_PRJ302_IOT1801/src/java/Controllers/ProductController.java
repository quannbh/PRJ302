/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import Models.Categories;
import Models.ProductDAO;
import Models.Products;
import Models.UserDAO;
import Models.Users;
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
public class ProductController extends HttpServlet {

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
            out.println("<title>Servlet ProductController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductController at " + request.getContextPath() + "</h1>");
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
        ProductDAO d = new ProductDAO();
        if (request.getParameter("mod") != null && request.getParameter("mod").equals("1")) {
            //get danh sach Category
            ArrayList<Categories> data1 = d.getCategories();
            request.setAttribute("data1", data1);
            request.getRequestDispatcher("AddProduct.jsp").forward(request, response);
        }

        if (request.getParameter("mod") != null && request.getParameter("mod").equals("2")) {
            String id = request.getParameter("id");
            d.deleteProduct(id);
        }

        if (request.getParameter("mod") != null && request.getParameter("mod").equals("3")) {
            //get danh sach Category
            ArrayList<Categories> data1 = d.getCategories();
            request.setAttribute("data1", data1);
            //get product tuong ung voi id truyen sang
            String id = request.getParameter("id");
            Products p = d.getProductById(id);
            request.setAttribute("p", p);
            request.getRequestDispatcher("UpdateProduct.jsp").forward(request, response);
        }

        ArrayList<Products> data = d.getProducts();
        if (request.getParameter("search") != null && !request.getParameter("name").isBlank()) {
            String searchName = request.getParameter("name");
            data = d.getProductsByName(searchName);
        }
        request.setAttribute("data", data);
        request.getRequestDispatcher("ListProduct.jsp").forward(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String stock = request.getParameter("stock");
        String image = request.getParameter("image");
        String category = request.getParameter("category");
        Products p = new Products(name, price, stock, image, category);
        ProductDAO d = new ProductDAO();

        if (request.getParameter("add") != null) {
            d.insertProduct(p);
        }

        if (request.getParameter("update") != null) {
            String id = request.getParameter("id");
            d.updateProduct(new Products(id, name, price, stock, image, category));
        }

        ArrayList<Products> data = d.getProducts();
        request.setAttribute("data", data);
        request.getRequestDispatcher("ListProduct.jsp").forward(request, response);
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

}
