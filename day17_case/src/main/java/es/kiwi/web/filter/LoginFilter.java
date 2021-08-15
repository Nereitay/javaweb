package es.kiwi.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 登录验证的过滤器
 * 需求：
 * 	1. 访问day17_case案例的资源。验证其是否登录
 * 	3. 如果登录了，则直接放行。
 * 	4. 如果没有登录，则跳转到登录页面，提示"您尚未登录，请先登录"。
 *
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException
            , IOException {
        //0. 强制转换
        HttpServletRequest req = (HttpServletRequest) request;

        //1. 资源的请求路径
        String uri = req.getRequestURI();
        //2. 判断是否包含登录相关资源路径，要注意排除 CSS/JS/图片/验证码等资源
        if (uri.contains("/login.jsp") || uri.contains("/loginServlet") || uri.contains("/css/")
                || uri.contains("/js/") || uri.contains("/font/") || uri.contains("/checkCodeServlet"))
            //包含，用户就是想登录，放行
            chain.doFilter(request, response);
        else {
            //不包含，需要验证用户是否登录
            //3. 从获取session中获取user
            Object user = req.getSession().getAttribute("user");
            if (user != null)
                // 登录了，放行
                chain.doFilter(request, response);
            else {
                // 没有登录，跳转登录页面
                req.setAttribute("login_msg", "您尚未登录，请登录");
                req.getRequestDispatcher("/login.jsp").forward(req, response);
            }
        }


    }
}
