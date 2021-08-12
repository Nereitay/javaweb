package es.kiwi.web.servlet;

import es.kiwi.service.UserService;
import es.kiwi.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/delUserServlet")
public class DelUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        UserService service = new UserServiceImpl();
        service.deleteUser(id);

        response.sendRedirect(request.getContextPath() + "/userListServlet");
    }
}
