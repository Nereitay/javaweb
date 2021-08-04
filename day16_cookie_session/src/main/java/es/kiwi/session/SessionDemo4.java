package es.kiwi.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 *案例：验证码
 *  1. 案例需求：
 * 	1. 访问带有验证码的登录页面login.jsp
 * 	2. 用户输入用户名，密码以及验证码。
 * 		* 如果用户名和密码输入有误，跳转登录页面，提示:用户名或密码错误
 * 		* 如果验证码输入有误，跳转登录页面，提示：验证码错误
 * 		* 如果全部输入正确，则跳转到主页success.jsp，显示：用户名,欢迎您
 *
 */
@WebServlet("/sessionDemo4")
public class SessionDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        //期望客户端关闭后，session也能相同
        Cookie c = new Cookie("JSESSIONID", session.getId());
        c.setMaxAge(60*60);
        response.addCookie(c);


        System.out.println(session);
    }
}
