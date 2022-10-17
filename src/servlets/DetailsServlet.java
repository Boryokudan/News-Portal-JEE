package servlets;

import main.DBManager;
import main.Language;
import main.Publication;
import main.Source;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "DetailsServlet", value = "/details")
public class DetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("currentPage", "/details?id=" + request.getParameter("id"));
        ArrayList<Language> languages = DBManager.getLanguages();
        HashMap<String, HashMap<String, String>> locales = Language.getLocales();
        ArrayList<Source> sources = DBManager.getSources();

        request.setAttribute("languages", languages);
        request.setAttribute("locales", locales);
        request.setAttribute("sources", sources);

        Long id = Long.parseLong(request.getParameter("id"));
        Publication publication = DBManager.getPublication(id);

        request.setAttribute("publication", publication);

        // Ensuring that current language matches the language of the publication;
        String currentLangCode = "";
        Cookie[] cookies = request.getCookies();
        Optional<Cookie> langOpt = Arrays.stream(cookies)
                .filter(cookie -> cookie.getName().equalsIgnoreCase("lang"))
                .findFirst();

        if (!langOpt.isEmpty()) {
            currentLangCode = langOpt.get().getValue();
        }

        if (publication.getNews().getLanguage().getCode().equals(currentLangCode)) {
            request.getRequestDispatcher("JSPs/details.jsp").forward(request, response);
        }
        else {
            response.sendRedirect("/access-error?error=404");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
