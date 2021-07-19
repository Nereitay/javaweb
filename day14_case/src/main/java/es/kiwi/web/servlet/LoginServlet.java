package es.kiwi.web.servlet;

import es.kiwi.dao.UserDAO;
import es.kiwi.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 用户登录案例需求：
 * 	1.编写login.html登录页面
 * 		username & password 两个输入框
 * 	2.使用Druid数据库连接池技术,操作mysql，day14数据库中user表
 * 	3.使用JdbcTemplate技术封装JDBC
 * 	4.登录成功跳转到SuccessServlet展示：登录成功！用户名,欢迎您
 * 	5.登录失败跳转到FailServlet展示：登录失败，用户名或密码错误
 */
@WebServlet(name = "LoginServlet", value = "/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

       /* String username = request.getParameter("username");
        String password = request.getParameter("password");

        User userLogin = new User();
        userLogin.setUsername(username);
        userLogin.setPassword(password);*/


        /*
        BeanUtils工具类，简化数据封装
		* 用于封装JavaBean的
		1. JavaBean：标准的Java类
			1. 要求：
				1. 类必须被public修饰
				2. 必须提供空参的构造器
				3. 成员变量必须使用private修饰
				4. 提供公共setter和getter方法
			2. 功能：封装数据

		2. 概念：
			成员变量：
			属性：setter和getter方法截取后的产物
				例如：getUsername() --> Username--> username

		3. 方法：
			1. setProperty()
			2. getProperty()
			3. populate(Object obj , Map map):将map集合的键值对信息，封装到对应的JavaBean对象中
         */
        //用BeanUtils来简化操作
        Map<String, String[]> parameterMap = request.getParameterMap();
        User userLogin = new User();
        try {
            BeanUtils.populate(userLogin, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        UserDAO userDAO = new UserDAO();
        User user = userDAO.login(userLogin);

        if (user == null) {
            request.getRequestDispatcher("/failServlet").forward(request, response);
        } else {
            request.setAttribute("user", user);
            request.getRequestDispatcher("/successServlet").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
