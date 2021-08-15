package es.kiwi.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 过滤器快速入门
 */
//@WebFilter("/*") // 访问所有资源之前，都会执行该过滤器
public class FilterDemo1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("filterDemo1被执行了...");

        //放行
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
