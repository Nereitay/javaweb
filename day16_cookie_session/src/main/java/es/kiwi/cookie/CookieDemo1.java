package es.kiwi.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * Cookie快速入门
 *  使用步骤：
 * 		1. 创建Cookie对象，绑定数据
 * 			* new Cookie(String name, String value)
 * 		2. 发送Cookie对象
 * 			* response.addCookie(Cookie cookie)
 * 		3. 获取Cookie，拿到数据
 * 			* Cookie[]  request.getCookies()
 *
 * 	实现原理
 * 	* 基于响应头set-cookie和请求头cookie实现
 */
@WebServlet("/cookieDemo1")
public class CookieDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.创建Cookie对象
        Cookie c = new Cookie("msg", "hello");

        //2.发送Cookie
        response.addCookie(c);
    }
}
