package es.kiwi.web.request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RequestDemo4", value = "/requestDemo4")
public class RequestDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String referer = request.getHeader("Referer");
        System.out.println(referer); // http://localhost:8080/day14_servlet_http_request/login.html

        //防盗链
        if (referer != null) {
            if (referer.contains("/day14_servlet_http_request")) {
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("播放电影");
//                System.out.println("播放电影");
            } else {
                System.out.println("想看电影，请登录本站...");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
