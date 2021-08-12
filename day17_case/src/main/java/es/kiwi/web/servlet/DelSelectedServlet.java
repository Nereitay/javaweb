package es.kiwi.web.servlet;

import es.kiwi.service.UserService;
import es.kiwi.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/delSelectedServlet")
public class DelSelectedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] uids = request.getParameterValues("uid");

        UserService service = new UserServiceImpl();
        service.delSelectedUser(uids);

        response.sendRedirect(request.getContextPath() + "/userListServlet");

    }
}
