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

@WebServlet(name = "Products", urlPatterns = "/products")
public class Products extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        Locale locale = (Locale) session.getAttribute("locale");
        String lang = req.getParameter("lang");

        if (lang != null) {
            locale = new Locale(lang);
            ResourceBundle bundle = ResourceBundle.getBundle("productStrings", locale);
            req.setAttribute("text", bundle.getString("whiteProdDesc"));

        } else {
            if (locale != null) {
                ResourceBundle bundle = ResourceBundle.getBundle("productStrings", locale);
                req.setAttribute("text", bundle.getString("whiteProdDesc"));
            } else {
                ResourceBundle bundle = ResourceBundle.getBundle("productStrings");
                req.setAttribute("text", bundle.getString("whiteProdDesc"));
            }
        }
        req.getRequestDispatcher("WEB-INF/Products.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
