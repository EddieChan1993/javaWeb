package com.example.web;

import com.example.model.BeerExpert;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

//@WebServlet("/beer")
public class BeerSelect extends HttpServlet {
    //一个http请求，实例化servlet
    //下次请求，将不再实例化，实例化对象常驻于内存中，除非服务器关闭
    public BeerSelect() {
        System.out.println("请求过来调用,1");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("请求过来调用,2");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String c = req.getParameter("color");

        if (c.equals("dark")) {
            //重定向
            resp.sendRedirect("http://www.baidu.com");
        } else if (c.equals("brown")) {
            //下载文件
            //常见的MIME类型
            //text/html application/pdf video/quicktime application/java image/jpeg application/jar application/octet-stream application/x-zip
            resp.setContentType("image/jpeg");
            ServletContext ctx = getServletContext();
            InputStream is = ctx.getResourceAsStream("/bookCode.txt");

            int read = 0;
            byte[] bytes = new byte[1024];

            ServletOutputStream os = resp.getOutputStream();
            while ((read = is.read(bytes)) != -1) {
                os.write(bytes, 0, read);
            }

            os.flush();
            os.close();
        } else {
            String[] users = req.getParameterValues("user");
            for (String i : users) {
                System.out.println(i);
            }

            BeerExpert be = new BeerExpert();
            List result = be.getBrands(c);

            //为请求对象增加一个属性，供JSP使用。注意，JSP要寻找styles
            req.setAttribute("styles", result);
            //为JSP实例化一个请求分派器
            RequestDispatcher view = req.getRequestDispatcher("result.jsp");
            //使用请求分派器要求容器准备好JSP，并向JSP发送请求和响应
            view.forward(req, resp);
        }
    }

    @Override
    public void destroy() {
        System.out.println("Tomcat关闭调用");
    }
}
