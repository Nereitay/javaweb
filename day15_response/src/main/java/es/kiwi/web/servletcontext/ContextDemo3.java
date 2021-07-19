package es.kiwi.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ContextDemo3", value = "/contextDemo3")
public class ContextDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        2. 域对象：共享数据
		    1. setAttribute(String name,Object value)
		    2. getAttribute(String name)
		    3. removeAttribute(String name)

		    * ServletContext对象范围：所有用户所有请求的数据
         */

        ServletContext context = this.getServletContext();

        context.setAttribute("msg", "Hello");

    }
}
