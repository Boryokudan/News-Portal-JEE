package servlets;

import main.DBManager;
import main.Language;
import main.Publication;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

@WebServlet(name = "LanguageServlet", value = "/language")
public class LanguageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String localeCode = request.getParameter("lang").toLowerCase();
        final String codeEN = "en";
        final String codeRU = "ru";

        if (localeCode.equalsIgnoreCase(codeEN) || localeCode.equalsIgnoreCase(codeRU)) {
            Cookie langCookie = new Cookie("lang", localeCode);
            langCookie.setMaxAge(3600 * 24 * 30);
            response.addCookie(langCookie);
        }

        response.sendRedirect("/");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
