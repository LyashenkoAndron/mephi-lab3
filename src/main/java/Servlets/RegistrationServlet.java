package Servlets;

import Service.UserService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Info;
import model.User;

import java.io.IOException;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userService = (UserService) getServletContext().getAttribute("userService");
        if (userService == null) {
            userService = new UserService();
            getServletContext().setAttribute("userService", userService);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String address = request.getParameter("address");

        if (userService.getUser(username) != null) {
            response.getWriter().write("This user is already exist");
        } else {
            User user = new User(username, password, new Info(name, email, address));
            userService.addUser(user);
            response.sendRedirect("userInfo.html?username=" + username + "&name=" + name + "&email=" + email);
        }
    }
}