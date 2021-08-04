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
 * 	1. 一次可不可以发送多个cookie?
 * 		* 可以
 * 		* 可以创建多个Cookie对象，使用response调用多次addCookie方法发送cookie即可。
 */
@WebServlet("/cookieDemo3")
public class CookieDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie c1 = new Cookie("msg", "hello");
        Cookie c2 = new Cookie("name", "Lucy");
        response.addCookie(c1);
        response.addCookie(c2);

    }
}
