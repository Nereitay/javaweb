package es.kiwi.web.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * Servlet生命周期
 */
public class ServletDemo2 implements Servlet {
    /**
     * 初始化方法：在servlet被创建时执行，只会执行一次，一般用于加载资源
     * @param servletConfig
     * @throws ServletException
     * * Servlet的init方法，只执行一次，说明一个Servlet在内存中只存在一个对象，Servlet是单例的
     * 			* 多个用户同时访问时，可能存在线程安全问题。
     * 			* 解决：尽量不要在Servlet中定义成员变量。即使定义了成员变量，也不要对修改值
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init......");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 提供服务方法
     * 每一次servlet被访问时执行，执行多次
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Hello Servlet!");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 销毁方法
     * 在服务器正常关闭时执行，执行一次
     * destroy方法在Servlet被销毁之前执行，一般用于释放资源
     */
    @Override
    public void destroy() {
        System.out.println("destroy......");
    }
}
