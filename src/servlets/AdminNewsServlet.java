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
import java.util.stream.Collectors;

@WebServlet (name = "AdminNewsServlet", value = "/admin_news" )
public class AdminNewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Language> languages = DBManager.getLanguages();
        HashMap<String, HashMap<String, String>> locales = Language.getLocales();

        request.setAttribute("languages", languages);
        request.setAttribute("locales", locales);

        User user = (User) request.getSession().getAttribute("activeUser");

        if (user != null && user.getRole() == 1) {
//            ArrayList<News> news = (ArrayList<News>) DBManager.getPublications().stream()
//                                                                .map(Publication::getNews)
//                                                                .collect(Collectors.toList());
            ArrayList<Publication> publications =  DBManager.getPublications();
            request.setAttribute("publications", publications);
            request.getRequestDispatcher("JSPs/admin.jsp?show=news").forward(request, response);
        }
        else {
            request.getRequestDispatcher("JSPs/access-denied.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
