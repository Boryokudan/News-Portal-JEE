package servlets;

import main.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet (name = "AdminPanel", value = "/admin-panel" )
public class AdminPanelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("currentPage", "/admin-panel");
        ArrayList<Language> languages = DBManager.getLanguages();
        HashMap<String, HashMap<String, String>> locales = Language.getLocales();

        request.setAttribute("languages", languages);
        request.setAttribute("locales", locales);

        User user = (User) request.getSession().getAttribute("activeUser");
        boolean userIsAdmin = user != null && user.getRole() == 1;

        if (!userIsAdmin) {
            request.getSession().setAttribute("currentPage", "/access-error?error=auth");
            response.sendRedirect("/access-error?error=auth");
        }

        String displayAction = "publications";
        String displayParam = request.getParameter("display");

        if (displayParam != null) {
            displayAction = displayParam;
        }

        if (displayAction.equals("publications")) {
            request.getSession().setAttribute("currentPage", "/admin-panel?display=publications");
            ArrayList<Publication> publications = DBManager.getPublications();
            ArrayList<Source> sources = DBManager.getSources();
            request.setAttribute("publications", publications);
            request.setAttribute("sources", sources);

            request.getRequestDispatcher("JSPs/admin.jsp?show=publications").forward(request, response);
        }
        else if (displayAction.equals("news")) {
            request.getSession().setAttribute("currentPage", "/admin-panel?display=news");
            ArrayList<Publication> publications =  DBManager.getPublications();
            request.setAttribute("publications", publications);
            request.getRequestDispatcher("JSPs/admin.jsp?show=news").forward(request, response);
        }
        else if (displayAction.equals("languages")) {
            request.getSession().setAttribute("currentPage", "/admin-panel?display=languages");
            request.getRequestDispatcher("JSPs/admin.jsp?show=languages").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
