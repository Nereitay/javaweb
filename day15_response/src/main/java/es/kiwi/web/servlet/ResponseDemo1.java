package es.kiwi.web.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 完成重定向
 *
 *      * 重定向的特点:redirect
 * 			1. 地址栏发生变化
 * 			2. 重定向可以访问其他站点(服务器)的资源
 * 			3. 重定向是两次请求。不能使用request对象来共享数据
 * 		* 转发的特点：forward
 * 			1. 转发地址栏路径不变
 * 			2. 转发只能访问当前服务器下的资源
 * 			3. 转发是一次请求，可以使用request对象来共享数据
 */
@WebServlet(name = "ResponseDemo1", value = "/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Demo1...........");
        request.setAttribute("msg", "Hello");

        /*response.setStatus(302);
        response.setHeader("location", "/day15_response/responseDemo2");*/

        //简单重定向方法
//        response.sendRedirect("/day15_response/responseDemo2");
//        response.sendRedirect("https://www.google.es");
        response.sendRedirect(request.getContextPath() + "/responseDemo2");
    }
}
