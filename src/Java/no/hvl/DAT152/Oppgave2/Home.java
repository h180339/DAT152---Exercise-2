package no.hvl.DAT152.Oppgave2;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

@WebServlet(name = "Home", urlPatterns = "/home")
public class Home extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        Cookie langCookie = CookieHelper.findCookie(cookies, "lang");
        Locale locale = req.getLocale();
        ResourceBundle bundle = ResourceBundle.getBundle("productStrings", locale);

        if (langCookie != null) {
            locale = new Locale(langCookie.getValue());
            bundle = ResourceBundle.getBundle("productStrings", locale);
            req.setAttribute("welcomeText", bundle.getString("welcomeText"));
            req.setAttribute("prod", bundle.getString("prod"));
        } else {
            req.setAttribute("welcomeText", bundle.getString("welcomeText"));
            req.setAttribute("prod", bundle.getString("prod"));
        }
        req.getRequestDispatcher("WEB-INF/Home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String wantedLang = req.getParameter("Lang");
        Cookie cookie = new Cookie("lang", wantedLang);
        resp.addCookie(cookie);
        resp.sendRedirect("./home");
    }
}
