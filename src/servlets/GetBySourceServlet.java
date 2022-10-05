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
import java.util.Set;

@WebServlet(name = "GetBySourceServlet", value = "/source")
public class GetBySourceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Publication> publications = DBManager.getPublications();
        ArrayList<Language> languages = DBManager.getLanguages();
        HashMap<String, HashMap<String, String>> locales = Language.getLocales();
        Set<String> sources = DBManager.getSources();
        String source = request.getParameter("src");
        source = source.replace("%20", " ");

        request.setAttribute("publications", publications);
        request.setAttribute("languages", languages);
        request.setAttribute("locales", locales);
        request.setAttribute("sources", sources);
        request.setAttribute("source", source);
        request.getRequestDispatcher("JSPs/source.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
