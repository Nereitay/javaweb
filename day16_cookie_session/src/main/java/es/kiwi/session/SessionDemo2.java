package es.kiwi.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Session快速入门
 *
 * 1. 概念：服务器端会话技术，在一次会话的多次请求间共享数据，将数据保存在服务器端的对象中。HttpSession
 * 2. 快速入门：
 * 	    1. 获取HttpSession对象：
 * 		    HttpSession session = request.getSession();
 * 	    2. 使用HttpSession对象：
 * 		    Object getAttribute(String name)
 * 		    void setAttribute(String name, Object value)
 * 		    void removeAttribute(String name)
 * 3. 原理
 * 	* Session的实现是依赖于Cookie的。
 */
@WebServlet("/sessionDemo2")
public class SessionDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object msg = session.getAttribute("msg");
        System.out.println(msg);
    }
}
