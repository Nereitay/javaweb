package es.kiwi.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 5. Cookie的特点和作用
 * 	1. cookie存储数据在客户端浏览器
 * 	2. 浏览器对于单个cookie 的大小有限制(4kb) 以及 对同一个域名下的总cookie数量也有限制(20个) -- 特指持久化到硬盘
 *
 * 	* 作用：
 * 		1. cookie一般用于存出少量的不太敏感的数据
 * 		2. 在不登录的情况下，完成服务器对客户端的身份识别
 */
@WebServlet("/cookieDemo2")
public class CookieDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //3. 获取Cookie，拿到数据
        Cookie[] cs = request.getCookies();
        // 获取数据，遍历cookie
        if (cs != null) {
            for (Cookie c : cs) {
                String value = c.getValue();
                System.out.println(c.getName() + " : " + value);
            }
        }

    }
}
