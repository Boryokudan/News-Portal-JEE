package servlets;

import main.DBManager;
import main.Language;
import main.Publication;
import main.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet (name = "AdminLanguagesServlet", value = "/admin_languages" )
public class AdminLanguagesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Language> languages = DBManager.getLanguages();
        HashMap<String, HashMap<String, String>> locales = Language.getLocales();

        request.setAttribute("languages", languages);
        request.setAttribute("locales", locales);

        User user = (User) request.getSession().getAttribute("activeUser");

        if (user != null && user.getRole() == 1) {
            request.getRequestDispatcher("JSPs/admin.jsp?show=languages").forward(request, response);
        }
        else {
            response.sendRedirect("/access-denied");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
