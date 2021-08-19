package es.kiwi.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
//        response.setContentType("text/html;Charset=utf-8");
        response.setContentType("application/json;Charset=utf-8");

        String username = request.getParameter("username");

        Map<String, Object> map = new HashMap<>();
        if("tom".equals(username)) {
            map.put("userExist", true);
            map.put("msg", "此用户名太受欢迎,请更换一个");
        } else {
            map.put("userExist", false);
            map.put("msg", "用户名可用");
        }

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(response.getWriter(), map);

    }
}
