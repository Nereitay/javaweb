package es.kiwi.web.servletcontext;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ContextDemo1", value = "/contextDemo1")
public class ContextDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        概念：代表整个web应用，可以和程序的容器(服务器)来通信
        servletContext对象获取
            1. 通过request对象获取
            2. 通过HttpServlet获取
         */
        ServletContext context1 = request.getServletContext();
        ServletContext context2 = this.getServletContext();
        System.out.println(context2 == context1); // true

    }
}
