/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import dal.DBContext;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Chứa các hàm xử lý database cho User
 *
 * @author ADMIN
 */
public class ProductDAO extends DBContext {

    public ProductDAO() {
        connectDB();
    }

    Connection cnn; //Dùng để kết nối database
    PreparedStatement stm; //Thực hiện các câu lệnh sql
    ResultSet rs; //Lưu trữ và xử lý dữ liệu lấy từ select

    //Khai báo các thành phần xử lý database
    private void connectDB() {
        cnn = connection;
        if (cnn != null) {
            System.out.println("Connect success!");
        } else {
            System.out.println("Connect failed!");
        }
    }

    public ArrayList<Products> getProducts() {
        ArrayList<Products> data = new ArrayList<Products>();
        try {
            String strSQL = "select * from Products p, Categories c where p.Categoryid=c.Categoryid";
            stm = cnn.prepareStatement(strSQL);
            rs = stm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String price = String.valueOf(rs.getDouble(3));
                String stock = String.valueOf(rs.getInt(4));
                String image = rs.getString(5);
                String category = rs.getString("CategoryName");
                Products p = new Products(id, name, price, stock, image, category);
                data.add(p);
            }
        } catch (Exception e) {
            System.out.println("getUsers: " + e.getMessage());
        }
        return data;
    }

    public void insertProduct(Products p) {
        try {
            String strSQL = "insert into Products(ProductName,UnitPrice,UnitsInStock,Image,CategoryID) values(?,?,?,?,?) ";
            stm = cnn.prepareStatement(strSQL);
            stm.setString(1, p.name);
            stm.setDouble(2, Double.valueOf(p.price));
            stm.setInt(3, Integer.valueOf(p.stock));
            stm.setString(4, p.image);
            stm.setInt(5, Integer.valueOf(p.category));
            stm.execute();
        } catch (Exception e) {
            System.out.println("insertProducts: " + e.getMessage());
        }
    }
    
    public ArrayList<Categories> getCategories() {
        ArrayList<Categories> data = new ArrayList<Categories>();
        try {
            String strSQL = "select * from Categories";
            stm = cnn.prepareStatement(strSQL);
            rs = stm.executeQuery();
            while (rs.next()) {
                String id = String.valueOf(rs.getInt(1));
                String name = rs.getString(2);
                Categories c = new Categories(id, name);
                data.add(c);
            }
        } catch (Exception e) {
            System.out.println("getCategories: " + e.getMessage());
        }
        return data;
    }
}
