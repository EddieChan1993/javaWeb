import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by EVE on 2017/11/19.
 */
@WebServlet("/aa")
public class HelloWorld extends HttpServlet {
    private String message;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

//设置逻辑实现
        PrintWriter out = resp.getWriter();
        out.println("<h1>"+message+"</h1>");
        System.out.println("asdf");
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
