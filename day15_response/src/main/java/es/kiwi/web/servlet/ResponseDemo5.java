package es.kiwi.web.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 输出字节数据
 */
@WebServlet(name = "ResponseDemo5", value = "/responseDemo5")
public class ResponseDemo5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setContentType("text/html;charset=utf-8");

        ServletOutputStream sos = response.getOutputStream();
        sos.write("hello".getBytes());
        sos.write("你好".getBytes(StandardCharsets.UTF_8));
    }
}
