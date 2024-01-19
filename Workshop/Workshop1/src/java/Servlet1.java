
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
public class Servlet1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            //Nhận thông tin từ client
            String a = req.getParameter("a");
            String b = req.getParameter("b");

            String checkInput = checkInput(a, b);
            if (!checkInput.equals("")) {
                out.print(checkInput);
                return;
            }
            
            //Xử lý thông tin
            String result = "";
            if (req.getParameter("okButton") != null) {
                if(req.getParameter("luaChon") != null){
                String luachon = req.getParameter("luaChon");
                if (luachon.equals("sumPrime")) { //Thay đổi option kích hoạt onchange
                    int c = calculatePrimeSum(Integer.parseInt(a), Integer.parseInt(b));
                    result = "Sum prime: " + c;
                } else if (luachon.equals("countPrime")) {
                    int c = calculatePrimeCount(Integer.parseInt(a), Integer.parseInt(b));
                    result = "Count prime: " + c;
                }
                } else {
                    result = "Please select operator.";
                }
            }
            //Trả kết quả về cho client
            out.print(result);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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

    private String checkInput(String a, String b) {
        if (a.isEmpty()) {
            if (b.isEmpty()) {
                return "Both inputs are empty!";
            }
            return "Input a is empty!";
        } else if (b.isEmpty()) {
            return "Input b is empty!";
        }
        if (!isInteger(a)) {
            return "Input a must be numbers";
        } else if (!isInteger(b)){
            return "Input b must be numbers";
        } else if (!isInteger(a) && !isInteger(b)){
            return "Both inputs must be numbers";
        }
        return "";
    }

    public static int calculatePrimeSum(int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                sum += i;
            }
        }
        return sum;
    }

    public static int calculatePrimeCount(int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                count += 1;
            }
        }
        return count;
    }

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
