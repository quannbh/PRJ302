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
public class UserDAO extends DBContext {

    public UserDAO() {
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

    public boolean checkUser(String account, String password) {
        try {
            String strSQL = "select * from Users where account=? and password=?";
            stm = cnn.prepareStatement(strSQL);
            stm.setString(1, account);
            stm.setString(2, password);
            rs = stm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("checkUser: " + e.getMessage());
        }
        return false;
    }

    public String getNameByAccount(String account) {
        try {
            String strSQL = "select * from Users where account=?";
            stm = cnn.prepareStatement(strSQL);
            stm.setString(1, account);
            rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getString(3);
            }
        } catch (Exception e) {
            System.out.println("checkUser: " + e.getMessage());
        }
        return "";
    }

    public ArrayList<Users> getUsers() {
        ArrayList<Users> data = new ArrayList<Users>();
        try {
            String strSQL = "select * from Users";
            stm = cnn.prepareStatement(strSQL);
            rs = stm.executeQuery();
            while (rs.next()) {
                String account = rs.getString(1);
                String password = rs.getString(2);
                String name = rs.getString(3);
                String gender = String.valueOf(rs.getString(4));
                String address = rs.getString(5);
                String dob = String.valueOf(rs.getDate(6));
                Users u = new Users(account, password, name, gender, address, dob);
                data.add(u);
            }
        } catch (Exception e) {
            System.out.println("getUsers: " + e.getMessage());
        }
        return data;
    }

    public void insert(Users u) {
        try {
            String strSQL = "insert into Users values(?,?,?,?,?,?) ";
            stm = cnn.prepareStatement(strSQL);
            stm.setString(1, u.account);
            stm.setString(2, u.password);
            stm.setString(3, u.name);
            stm.setString(4, u.gender);
            stm.setString(5, u.address);
            stm.setDate(6, Date.valueOf(u.dob));
            stm.execute();
        } catch (Exception e) {
            System.out.println("insert: " + e.getMessage());
        }
    }
}
