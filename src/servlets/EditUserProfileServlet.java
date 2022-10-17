package servlets;

import main.DBManager;
import main.Language;
import main.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet (name = "EditUserProfileServlet", value = "/edit-user-profile")
public class EditUserProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Language> languages = DBManager.getLanguages();
        HashMap<String, HashMap<String, String>> locales = Language.getLocales();

        request.setAttribute("languages", languages);
        request.setAttribute("locales", locales);

        String fullName = request.getParameter("full_name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        boolean emailIsInUse = DBManager.getUser(email) != null;
        User activeUser = (User) request.getSession().getAttribute("activeUser");

        if (activeUser != null && !emailIsInUse && password != null) {
            User editedUser = new User();
            editedUser.setId(activeUser.getId());
            editedUser.setEmail(email);
            editedUser.setPassword(password);
            editedUser.setFullName(fullName);

            DBManager.editUserData(editedUser);
            request.getSession().setAttribute("activeUser", editedUser);

            response.sendRedirect("/profile");
        }
        else if (activeUser == null) {
            request.getSession().setAttribute("currentPage", "/access-error?error=auth");
            response.sendRedirect("/access-error?error=auth");
        }
        else if (emailIsInUse ){
            request.getRequestDispatcher("JSPs/profile.jsp?error=email-edit-error").forward(request, response);
        }

    }
}
