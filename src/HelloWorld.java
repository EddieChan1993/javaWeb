import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/beer")
//99.9999%的servlet都是HttpServlet
public class HelloWorld extends HttpServlet {
    private String message;

    @Override
    //99.9%的servlet都会覆盖doGet或doPost方法
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET请求收到");
        resp.setContentType("text/html");

        //在servlet从容器得到的响应对象中，
        //可以拿到一个PrintWriter，使用这个
        //PrintWriter能够将HTML文本输出到响应对象
        PrintWriter out = resp.getWriter();
        out.println("<h1>" + message + "</h1>");
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
// super.init();
        message = "Hello World";
    }
}
