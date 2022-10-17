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

@WebServlet (name = "RegistrationServlet", value = "/registration")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("currentPage", "/registration");
        ArrayList<Language> languages = DBManager.getLanguages();
        HashMap<String, HashMap<String, String>> locales = Language.getLocales();

        request.setAttribute("languages", languages);
        request.setAttribute("locales", locales);

        request.getRequestDispatcher("JSPs/registration.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Language> languages = DBManager.getLanguages();
        HashMap<String, HashMap<String, String>> locales = Language.getLocales();

        request.setAttribute("languages", languages);
        request.setAttribute("locales", locales);

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String rePassword = request.getParameter("re_password");
        String fullName = request.getParameter("full_name");

        boolean nullFieldsPassed = email == null || password == null || rePassword == null || fullName == null;

        if (nullFieldsPassed)
            request.getRequestDispatcher("JSPs/registration.jsp?error=null-fields").forward(request, response);

        boolean emptyFieldsPassed = email.trim().equals("") || password.trim().equals("") || rePassword.trim().equals("") ||
                fullName.trim().equals("");

        if (emptyFieldsPassed) {
            request.getRequestDispatcher("JSPs/registration.jsp?error=null-fields").forward(request, response);
        }

        boolean userExists = DBManager.getUser(email) != null;

        if (!userExists) {
            if (password.equals(rePassword) && !password.trim().equalsIgnoreCase("")) {
                User newUser = new User();

                newUser.setEmail(email);
                newUser.setPassword(password);
                newUser.setFullName(fullName);

                DBManager.addUser(newUser);
                response.sendRedirect("/authentication");
            }
            else {
                request.getRequestDispatcher("JSPs/registration.jsp?error=passwords-error").forward(request, response);
            }
        }
        else {
            request.getRequestDispatcher("JSPs/registration.jsp?error=email-error").forward(request, response);
        }
    }
}
