package es.kiwi.web.listener;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@WebListener
public class ContextLoaderListener implements ServletContextListener{

    public ContextLoaderListener() {
    }

    /**
     * 监听servletContext对象创建，servletContext在服务器启动后自动创建
     * 在服务器启动后自动调用
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */
        System.out.println("ServletContext对象被创建了。。。");

        //加载资源文件
        //1. 获取servletContext对象
        ServletContext servletContext = sce.getServletContext();

        //2. 加载资源文件
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");

        //3. 获取真实路径
        String realPath = servletContext.getRealPath(contextConfigLocation);

        //4. 加载进内存
        try {
            FileInputStream fis = new FileInputStream(realPath);
            System.out.println(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * 在服务器关闭后，ServletContext对象被销毁。当服务器正常关闭后该方法被调用
     * @param sce
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
        System.out.println("ServletContext对象被销毁了。。。");
    }


}
