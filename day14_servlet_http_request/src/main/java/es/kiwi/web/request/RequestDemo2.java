package es.kiwi.web.request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 2. 获取请求头数据
 * 			* 方法：
 * 				* (*)String getHeader(String name):通过请求头的名称获取请求头的值
 * 				* Enumeration<String> getHeaderNames():获取所有的请求头名称
 */
@WebServlet(name = "RequestDemo2", value = "/requestDemo2")
public class RequestDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            String header = request.getHeader(name);
            System.out.println(name + " : " + header);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
