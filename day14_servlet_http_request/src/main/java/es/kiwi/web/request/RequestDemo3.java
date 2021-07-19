package es.kiwi.web.request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 演示获取请求头数据
 */
@WebServlet(name = "RequestDemo3", value = "/requestDemo3")
public class RequestDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String agent = request.getHeader("User-Agent");//不区分大小写
        if (agent.contains("Chrome")) {
            System.out.println("谷歌浏览器");
        } else if (agent.contains("Firefox")) {
            System.out.println("火狐浏览器");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
