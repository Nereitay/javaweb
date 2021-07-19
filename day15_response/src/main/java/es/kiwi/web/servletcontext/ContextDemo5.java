package es.kiwi.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet(name = "ContextDemo5", value = "/contextDemo5")
public class ContextDemo5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        3. 获取文件的真实(服务器)路径
		1. 方法：String getRealPath(String path)
			 String b = context.getRealPath("/b.txt");//web目录下资源访问
	         System.out.println(b);

	        String c = context.getRealPath("/WEB-INF/c.txt");//WEB-INF目录下的资源访问
	        System.out.println(c);

	        String a = context.getRealPath("/WEB-INF/classes/a.txt");//src目录下的资源访问
	        System.out.println(a);
         */

        ServletContext context = this.getServletContext();
        // 获取文件服务器路径, classLoader获取不到webapp目录下的文件
        String realPath = context.getRealPath("/b.txt"); // web目录下资源访问
        System.out.println(realPath);
//        File file = new File(realPath);

        String realPath1 = context.getRealPath("/WEB-INF/c.txt"); // WEB-INF目录下的资源访问
        System.out.println(realPath1);

        String realPath2 = context.getRealPath("/WEB-INF/classes/a.txt"); // src目录下的资源访问
        System.out.println(realPath2);

    }
}
