package es.kiwi.web.request;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *4. 获取ServletContext：
 * 			* ServletContext getServletContext()
 */
@WebServlet(name = "RequestDemo10", value = "/requestDemo10")
public class RequestDemo10 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Demo10..........");
        ServletContext servletContext = request.getServletContext();
        System.out.println(servletContext);
    }
}
