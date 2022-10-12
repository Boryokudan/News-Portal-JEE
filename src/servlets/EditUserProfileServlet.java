package servlets;

import main.DBManager;
import main.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "EditUserProfileServlet", value = "/edit-user-profile")
public class EditUserProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullName = request.getParameter("full_name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User activeUser = (User) request.getSession().getAttribute("activeUser");

        if (activeUser != null) {
            User editedUser = new User();
            editedUser.setId(activeUser.getId());
            editedUser.setEmail(email);
            editedUser.setPassword(password);
            editedUser.setFullName(fullName);

            DBManager.editUserData(editedUser);
            request.getSession().setAttribute("activeUser", editedUser);

            response.sendRedirect("/profile");
        }

    }
}
