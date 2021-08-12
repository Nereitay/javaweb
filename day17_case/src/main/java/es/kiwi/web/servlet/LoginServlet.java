package es.kiwi.web.servlet;

import es.kiwi.domain.User;
import es.kiwi.service.UserService;
import es.kiwi.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 设置编码
        request.setCharacterEncoding("utf-8");

        //2. 获取数据
        // 2.1 获取用户填写的验证码
        String verifycode = request.getParameter("verifycode");

        //3. 验证码校验
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER"); // 确保验证码一次性
        if (!checkcode_server.equalsIgnoreCase(verifycode)) {
            // 验证码不正确
            // 提示信息
            request.setAttribute("login_msg", "验证码错误！");
            // 跳转登录页面
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }

        Map<String, String[]> map = request.getParameterMap();

        //4. 封装User对象
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }


        //5. 调用Service查询
        UserService service = new UserServiceImpl();
        User loginUser = service.login(user);

        if (loginUser != null) {
            // 登录成功
            // 将用户存入session
            session.setAttribute("user", loginUser);
            // 跳转页面
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }else {
            // 验证码不正确
            // 提示信息
            request.setAttribute("login_msg", "用户名或密码错误！");
            // 跳转登录页面
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

        //6. 判断是否登录成功

    }
}
