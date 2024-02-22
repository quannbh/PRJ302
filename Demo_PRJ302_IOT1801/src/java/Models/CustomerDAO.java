/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import dal.DBContext;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class CustomerDAO extends DBContext {
    public CustomerDAO() {
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

    public ArrayList<Customers> getCustomers() {
        ArrayList<Customers> data = new ArrayList<Customers>();
        try {
            String strSQL = "select * from Customers";
            stm = cnn.prepareStatement(strSQL);
            rs = stm.executeQuery();
            while (rs.next()) {
                String customerID = rs.getString(1);
                String customerName = rs.getString(2);
                String gender = rs.getString(3);
                String address = rs.getString(4);
                String dob = String.valueOf(rs.getDate(5));
                Customers c = new Customers(customerID, customerName, gender, address, dob);
                data.add(c);
                System.out.println(data);
            }
        } catch (Exception e) {
            System.out.println("getCustomers: " + e.getMessage());
        }
        return data;
    }

    public void insertCustomer(Customers c) {
        try {
            String strSQL = "insert into Users values(?,?,?,?,?,?) ";
            stm = cnn.prepareStatement(strSQL);
            stm.setString(1, c.customerID);
            stm.setString(2, c.customerName);
            stm.setString(3, c.gender);
            stm.setString(4, c.address);
            stm.setDate(5, Date.valueOf(c.dob));
            stm.execute();
        } catch (Exception e) {
            System.out.println("insertCustomer: " + e.getMessage());
        }
    }
}
