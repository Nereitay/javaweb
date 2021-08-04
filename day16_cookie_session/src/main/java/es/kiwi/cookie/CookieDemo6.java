package es.kiwi.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * cookie的细节
 * 	4. cookie共享问题？
 * 		1. 假设在一个tomcat服务器中，部署了多个web项目，那么在这些web项目中cookie能不能共享？
 * 			* 默认情况下cookie不能共享
 *
 * 			* setPath(String path):设置cookie的获取范围。默认情况下，设置当前的虚拟目录
 * 				* 如果要当前服务器上部署的多个项目之间共享，则可以将path设置为"/"
 * 		2. 不同的tomcat服务器间cookie共享问题？
 * 			* setDomain(String path):如果设置一级域名相同，那么多个服务器之间cookie可以共享
 * 				* setDomain(".baidu.com"),那么tieba.baidu.com和news.baidu.com中cookie可以共享
 */
@WebServlet("/cookieDemo6")
public class CookieDemo6 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie c1 = new Cookie("msg", "setPath");

        c1.setPath("/");

//        c1.setDomain(".baidu.com"); // 一级域名

        response.addCookie(c1);

    }
}
