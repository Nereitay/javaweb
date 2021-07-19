package es.kiwi.web.request;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 2. 请求转发：一种在服务器内部的资源跳转方式
 * 		1. 步骤：
 * 			1. 通过request对象获取请求转发器对象：RequestDispatcher getRequestDispatcher(String path)
 * 			2. 使用RequestDispatcher对象来进行转发：forward(ServletRequest request, ServletResponse response)
 */
@WebServlet(name = "RequestDemo9", value = "/requestDemo9")
public class RequestDemo9 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Demo9..........");
        Object msg = request.getAttribute("msg");
        System.out.println(msg);
    }
}
