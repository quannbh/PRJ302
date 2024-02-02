/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import dal.DBContext;
import java.sql.*;

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

}
