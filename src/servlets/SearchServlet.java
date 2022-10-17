package servlets;

import main.DBManager;
import main.Language;
import main.Publication;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet (name = "SearchServlet", value = "/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Language> languages = DBManager.getLanguages();
        HashMap<String, HashMap<String, String>> locales = Language.getLocales();

        request.setAttribute("languages", languages);
        request.setAttribute("locales", locales);

        String searchType = request.getParameter("type");
        System.out.println(searchType);

        if (searchType != null) {
            if (searchType.equals("publications")) {
                String searchValue = request.getParameter("search-value");
                ArrayList<Publication> publications = DBManager.searchPublications(searchValue);
                request.setAttribute("publications", publications);
                request.getRequestDispatcher("JSPs/admin.jsp?show=publications").forward(request, response);
            }
            else if (searchType.equals("news")) {
                String searchValue = request.getParameter("search-value");
                ArrayList<Publication> publications = DBManager.searchPublications(searchValue);
                request.setAttribute("publications", publications);
                request.getRequestDispatcher("JSPs/admin.jsp?show=news").forward(request, response);
            }
            else if (searchType.equals("languages")) {

            }
            else {
                response.sendRedirect("/admin-panel?display=publications");
            }
        }
        else {
            response.sendRedirect("/admin-panel?display=publications");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
