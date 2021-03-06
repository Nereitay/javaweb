package es.kiwi.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置request编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //2.获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");

        //3.先获取生成的验证码
        HttpSession session = request.getSession();
        String checkCode_session = (String) session.getAttribute("checkCode_session");

        //删除session中存储的验证码
        session.removeAttribute("checkCode_session");

        //3.先判断验证码是否正确
        if (checkCode_session != null && checkCode_session.equalsIgnoreCase(checkCode)) {
            //忽略大小写比较
            //验证码正确
            //判断用户名和密码是否一致
            if ("Lucy".equals(username) && "123".equals(password)) {
                //登录成功
                //存储信息，用户信息
                session.setAttribute("username", username);
                //重定向到success.jsp
                response.sendRedirect(request.getContextPath() + "/success.jsp");
            } else {
                //登录失败
                //存储提示信息到request
                request.setAttribute("login_error", "用户名或密码错误");
                //转发到登录页面
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }

        } else {
            //验证码不一致
            //存储提示信息到request
            request.setAttribute("cc_error", "验证码错误");
            //转发到登录页面
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
