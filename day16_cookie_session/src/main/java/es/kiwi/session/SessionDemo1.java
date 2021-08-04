package es.kiwi.session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
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
 */
@WebServlet("/sessionDemo1")
public class SessionDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("msg", "hello");
    }
}
