package es.kiwi.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  Servlet相关配置
 * 	1. urlpartten:Servlet访问路径
 * 		1. 一个Servlet可以定义多个访问路径 ： @WebServlet({"/d4","/dd4","/ddd4"})
 * 		2. 路径定义规则：
 * 			1. /xxx：路径匹配
 * 			2. /xxx/xxx:多层路径，目录结构
 * 			3. *.do：扩展名匹配,前面不能加 /
 */
//@WebServlet({"/d4", "/d04", "/d004"})
//@WebServlet({"/user/demo4"})
//@WebServlet({"/user/*"})
//@WebServlet({"/*"})
@WebServlet({"*.do"})
public class ServletDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Demo4...");
        /**
         * request对象继承体系结构：
         * 	ServletRequest		--	接口
         * 		|	继承
         * 	HttpServletRequest	-- 接口
         * 		|	实现
         * 	org.apache.catalina.connector.RequestFacade 类(tomcat)
         */
        System.out.println(req);
    }
}
