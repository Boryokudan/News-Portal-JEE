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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;

@WebServlet(name = "SourceServlet", value = "/source")
public class SourceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Publication> publications = DBManager.getPublications();
        ArrayList<Language> languages = DBManager.getLanguages();
        HashMap<String, HashMap<String, String>> locales = Language.getLocales();
        ArrayList<Source> sources = DBManager.getSources();

        request.setAttribute("publications", publications);
        request.setAttribute("languages", languages);
        request.setAttribute("locales", locales);
        request.setAttribute("sources", sources);

        String sourceName = request.getParameter("src");
        sourceName = sourceName.replace("%20", " ");

        // Retrieving Source object;
        Source source = new Source();
        String finalSourceName = sourceName;
        Optional<Source> srcOpt = sources.stream().filter(s -> s.getSourceName().equals(finalSourceName)).findFirst();
        if (srcOpt.isPresent()) {
            source = srcOpt.get();
        }

        // Ensuring that current language matches the language of the Source;
        String currentLangCode = "en";
        Cookie[] cookies = request.getCookies();
        Optional<Cookie> langOpt = Arrays.stream(cookies)
                .filter(cookie -> cookie.getName().equalsIgnoreCase("lang"))
                .findFirst();

        if (langOpt.isPresent()) {
            currentLangCode = langOpt.get().getValue();
        }

        System.out.println(currentLangCode);
        System.out.println(source.getSourceLangCode());

        if (source != null) {
            if (source.getSourceLangCode().equalsIgnoreCase(currentLangCode)) {
                request.getSession().setAttribute("currentPage", "/source?src=" + sourceName);
                request.setAttribute("source", sourceName);
                request.getRequestDispatcher("JSPs/source.jsp").forward(request, response);
            }
            else {
                request.getSession().setAttribute("currentPage", "/source?src=" + sourceName);
                response.sendRedirect("/access-error?error=404");
            }
        }
        else {
            request.getSession().setAttribute("currentPage", "/source?src=" + sourceName);
            response.sendRedirect("/access-error?error=404");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
