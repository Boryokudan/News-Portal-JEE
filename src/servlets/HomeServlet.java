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
import java.util.List;
import java.util.Set;

@WebServlet(name = "HomeServlet", value = "/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Publication> publications = DBManager.getPublications();
        ArrayList<Language> languages = DBManager.getLanguages();
        Set<String> sources = DBManager.getSources();

        System.out.println(languages.get(0).getName());

        request.setAttribute("publications", publications);
        request.setAttribute("languages", languages);
        request.setAttribute("sources", sources);
        request.getRequestDispatcher("JSPs/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
