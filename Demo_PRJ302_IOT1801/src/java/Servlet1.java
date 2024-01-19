
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Servlet1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
            //Trả kết quả về cho client
            out.print(result);
        }
    }

    //Khi nào thì hàm doGet() được gọi:
    //1.Khi chạy trực tiếp servlet này = run file hoặc gõ url lên trình duyệt
    //2.Gọi đến servlet này mà không set method hoặc set method=get
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            out.print("Welcome to Servlet!");
            out.print("<form method='post'>");
            out.print("Enter a:<input type='text' name='a'><br>");
            out.print("Enter b:<input type='text' name='b'><br>");
            out.print("<input type='submit' name='cong' value='a+b'>");
            out.print("<input type='submit' name='tru' value='a-b'>");
            out.print("<input type='submit' name='nhan' value='a*b'>");
            out.print("<input type='submit' name='chia' value='a/b'><br>");
            out.print("</form>");

            //Nhận thông tin từ client
            String a = req.getParameter("a");
            String b = req.getParameter("b");
            //Xử lý thông tin
            String result = "";

            if (req.getParameter("cong") != null) { //Mày nhấn nút a + b
                int c = Integer.parseInt(a) + Integer.parseInt(b);
                result = "a + b = " + c;
            }
            if (req.getParameter("tru") != null) { //Mày nhấn nút a - b
                int c = Integer.parseInt(a) - Integer.parseInt(b);
                result = "a - b = " + c;
            }
            if (req.getParameter("nhan") != null) { //Mày nhấn nút a * b
                int c = Integer.parseInt(a) * Integer.parseInt(b);
                result = "a * b = " + c;
            }
            if (req.getParameter("chia") != null) { //Mày nhấn nút a / b
                double c = Double.parseDouble(a) / Double.parseDouble(b);
                result = "a / b = " + c;
            }
            //Trả kết quả về cho client
            out.print(result);
        }
    }

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
