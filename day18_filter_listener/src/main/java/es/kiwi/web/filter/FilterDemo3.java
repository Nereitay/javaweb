package es.kiwi.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 过滤器执行流程
 * 		1. 执行过滤器
 * 		2. 执行放行后的资源
 * 		3. 回来执行过滤器放行代码下边的代码
 * 	过滤器生命周期方法
 * 		1. init:在服务器启动后，会创建Filter对象，然后调用init方法。只执行一次。用于加载资源
 * 		2. doFilter:每一次请求被拦截资源时，会执行。执行多次
 * 		3. destroy:在服务器关闭后，Filter对象被销毁。如果服务器是正常关闭，则会执行destroy方法。只执行一次。用于释放资源
 */
//@WebFilter("/*")
public class FilterDemo3 implements Filter {
    /**
     * 在服务器启动后，会创建Filter对象，然后调用init方法。只执行一次。用于加载资源
     * @param config
     * @throws ServletException
     */
    public void init(FilterConfig config) throws ServletException {
        System.out.println("init..........");
    }

    /**
     * 在服务器关闭后，Filter对象被销毁。如果服务器是正常关闭，则会执行destroy方法。只执行一次。用于释放资源
     */
    public void destroy() {
        System.out.println("destroy.........");
    }

    /**
     * 每一次请求被拦截资源时，会执行。执行多次
     * @param request
     * @param response
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("doFilter......");
        chain.doFilter(request, response);
    }
}
