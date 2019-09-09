package no.hvl.DAT152.Oppgave2;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

@WebServlet(name = "Home", urlPatterns = "/home")
public class Home extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String lang = req.getParameter("lang");
        HttpSession session = req.getSession(true);

        if (lang != null) {
            Locale locale = new Locale(lang);
            ResourceBundle bundle = ResourceBundle.getBundle("productStrings", locale);
            session.setAttribute("locale", locale);
            req.setAttribute("welcomeText", bundle.getString("welcomeText"));
            req.setAttribute("prod", bundle.getString("prod"));
        } else {
            ResourceBundle bundle = ResourceBundle.getBundle("productStrings");
            req.setAttribute("welcomeText", bundle.getString("welcomeText"));
            req.setAttribute("prod", bundle.getString("prod"));
        }
        req.getRequestDispatcher("WEB-INF/Home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
