package servlets;

import main.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "DeletePublicationServlet", value = "/delete")
public class DeletePublicationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String objectToDelete = request.getParameter("object");
        Long idToDelete = Long.parseLong(request.getParameter("id"));
        if (objectToDelete != null && idToDelete != null) {
            if (objectToDelete.equals("publication")) {
                DBManager.deletePublication(DBManager.getPublication(idToDelete).getNews().getId());
                response.sendRedirect("/admin-panel?display=publications");
            }
            else if (objectToDelete.equals("news")) {
                DBManager.deletePublication(DBManager.getPublication(idToDelete).getNews().getId());
                response.sendRedirect("/admin-panel?display=news");
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
