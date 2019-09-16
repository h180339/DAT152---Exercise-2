package no.hvl.DAT152.Oppgave2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;


/**
 * A servlet that shows the home page of a website that sells coffee cups
 *
 * @author Gruppe 5
 * @version 1.0.0
 */
@WebServlet(name = "Home", urlPatterns = "/home")
public class Home extends HttpServlet {

    /**
     * Shows Home page of website
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String langCookie = LocaleHelper.getLang(req);
        Locale locale = req.getLocale();
        if (langCookie != null) {
            String[] location = langCookie.split("_");
            locale = new Locale(location[0], location[1]);
            req.setAttribute("langLocale", locale);
        } else {
            req.setAttribute("langLocale", locale);
        }


        ResourceBundle bundle = ResourceBundle.getBundle("productStrings", locale);
        req.setAttribute("welcomeText", bundle.getString("welcomeText"));
        req.setAttribute("prod", bundle.getString("prod"));

        req.getRequestDispatcher("WEB-INF/Home.jsp").forward(req, resp);
    }

    /**
     * Sets the language that the user wants
     *
     * @param req
     * @param resp
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String wantedLang = req.getParameter("Lang");
        Cookie cookie = new Cookie("lang", wantedLang);
        resp.addCookie(cookie);
        resp.sendRedirect("./home");
    }
}
