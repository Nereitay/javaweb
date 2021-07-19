package es.kiwi.web.request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 获取请求消息数据
 * 		1. 获取请求行数据
 * 			* 请求方式 请求url 请求协议/版本
 * 			* GET /day14/demo1?name=zhangsan HTTP/1.1
 * 			* 方法：
 * 				1. 获取请求方式 ：GET
 * 					* String getMethod()
 * 				2. (*)获取虚拟目录：/day14
 * 					* String getContextPath()
 * 				3. 获取Servlet路径: /demo1
 * 					* String getServletPath()
 * 				4. 获取get方式请求参数：name=zhangsan
 * 					* String getQueryString()
 * 				5. (*)获取请求URI：/day14/demo1
 * 					* String getRequestURI():		/day14/demo1
 * 					* StringBuffer getRequestURL()  :http://localhost/day14/demo1
 *
 * 					* URL:统一资源定位符 ： http://localhost/day14/demo1	中华人民共和国
 * 					* URI：统一资源标识符 : /day14/demo1					共和国
 *
 * 				6. 获取协议及版本：HTTP/1.1
 * 					* String getProtocol()
 *
 * 				7. 获取客户机的IP地址：
 * 					* String getRemoteAddr()
 */
@WebServlet(name = "RequestDemo1", value = "/requestDemo1")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getMethod();
        System.out.println(method); // GET

        String contextPath = request.getContextPath();
        System.out.println(contextPath); ///day14_servlet_http_request

        String servletPath = request.getServletPath(); // /requestDemo1
        System.out.println(servletPath);

        String queryString = request.getQueryString(); // name=lemon&age=3
        System.out.println(queryString);

        String requestURI = request.getRequestURI(); // /day14_servlet_http_request/requestDemo1
        System.out.println(requestURI);

        StringBuffer requestURL = request.getRequestURL();// http://localhost:8080/day14_servlet_http_request/requestDemo1
        System.out.println(requestURL);

        String protocol = request.getProtocol(); // HTTP/1.1
        System.out.println(protocol);

        String remoteAddr = request.getRemoteAddr(); // 0:0:0:0:0:0:0:1
        System.out.println(remoteAddr);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
