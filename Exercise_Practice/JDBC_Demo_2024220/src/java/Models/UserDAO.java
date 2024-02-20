/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import dal.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
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
            String strSQL = "select * from users where username=? and password=?";
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

    public ArrayList<Students> getAllStudents(String account) {
        ArrayList<Students> data = new ArrayList<Students>();
        try {
            String strSQL = "select * from students join users ON students.class = users.class where users.username = ?";
            stm = cnn.prepareStatement(strSQL);
            stm.setString(1, account);
            rs = stm.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String classes = rs.getString("class");
                double mark = rs.getDouble("mark");
                Students studentInfo = new Students(name, classes, mark);
                data.add(studentInfo);
            }
        } catch (Exception e) {
            System.out.println("checkUser: " + e.getMessage());
        }
        return data;
    }

}
