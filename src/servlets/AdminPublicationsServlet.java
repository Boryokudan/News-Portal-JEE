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

@WebServlet (name = "AdminPublicationsServlet", value = "/admin_publications" )
public class AdminPublicationsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Language> languages = DBManager.getLanguages();
        HashMap<String, HashMap<String, String>> locales = Language.getLocales();

        request.setAttribute("languages", languages);
        request.setAttribute("locales", locales);

        User user = (User) request.getSession().getAttribute("activeUser");

        if (user != null && user.getRole() == 1) {
            ArrayList<Publication> publications = DBManager.getPublications();
            request.setAttribute("publications", publications);
            request.getRequestDispatcher("JSPs/admin.jsp?show=publications").forward(request, response);
        }
        else {
            request.getRequestDispatcher("JSPs/access-denied.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
