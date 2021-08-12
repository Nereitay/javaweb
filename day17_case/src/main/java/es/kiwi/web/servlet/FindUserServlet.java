package es.kiwi.web.servlet;

import es.kiwi.domain.User;
import es.kiwi.service.UserService;
import es.kiwi.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        UserService service = new UserServiceImpl();
        User user = service.findUserById(id);

        request.setAttribute("user", user);
        request.getRequestDispatcher("/update.jsp").forward(request, response);
    }
}
