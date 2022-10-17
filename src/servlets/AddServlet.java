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

@WebServlet (name = "AddServlet", value = "/add" )
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String add = request.getParameter("add");
        System.out.println(add);

        if (add != null && add.equals("publication")) {
            Long sourceID = Long.parseLong(request.getParameter("source"));
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            String content = request.getParameter("content");
            Long langID = Long.parseLong(request.getParameter("language"));
            String imageURL = request.getParameter("image-url");
            double rating = Double.parseDouble(request.getParameter("rating"));

            News news = new News();
            news.setSourceById(sourceID);
            news.setTitle(title);
            news.setDescription(description);
            news.setContent(content);
            news.setLanguageById(langID);
            news.setImageURL(imageURL);

            int newsID = DBManager.addNews(news);

            Publication publication = new Publication();
            publication.setNews(news);
            publication.setRating(rating);

            DBManager.addPublication(publication, newsID);

            response.sendRedirect("/admin-panel?display=publications");
        }
    }
}
