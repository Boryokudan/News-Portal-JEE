package servlets;

import main.DBManager;
import main.Language;
import main.Publication;
import main.Source;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet(name = "IndexServlet", value = "/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("currentPage", "/index");

        ArrayList<Publication> publications = DBManager.getPublications();
        ArrayList<Language> languages = DBManager.getLanguages();
        HashMap<String, HashMap<String, String>> locales = Language.getLocales();
        ArrayList<Source> sources = DBManager.getSources();

        request.setAttribute("publications", publications);
        request.setAttribute("languages", languages);
        request.setAttribute("locales", locales);
        request.setAttribute("sources", sources);

        request.getRequestDispatcher("JSPs/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
