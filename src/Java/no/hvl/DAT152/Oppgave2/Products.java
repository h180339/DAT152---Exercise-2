package no.hvl.DAT152.Oppgave2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

@WebServlet(name = "Products", urlPatterns = "/products")
public class Products extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        Cookie langCookie = CookieHelper.findCookie(cookies, "lang");
        Locale locale = req.getLocale();
        ResourceBundle bundle = ResourceBundle.getBundle("productStrings", locale);

        if (langCookie != null) {
            locale = new Locale(langCookie.getValue());
            bundle = ResourceBundle.getBundle("productStrings", locale);
            req.setAttribute("whiteProdDesc", bundle.getString("whiteProdDesc"));
            req.setAttribute("blackProdDesc", bundle.getString("blackProdDesc"));
            req.setAttribute("yellowProdDesc", bundle.getString("yellowProdDesc"));
            req.setAttribute("whitePrice", bundle.getString("whitePrice"));
            req.setAttribute("blackPrice", bundle.getString("blackPrice"));
            req.setAttribute("yellowPrice", bundle.getString("yellowPrice"));
            req.setAttribute("whiteName", bundle.getString("whiteName"));
            req.setAttribute("blackName", bundle.getString("blackName"));
            req.setAttribute("yellowName", bundle.getString("yellowName"));
        } else {
            req.setAttribute("whiteProdDesc", bundle.getString("whiteProdDesc"));
            req.setAttribute("blackProdDesc", bundle.getString("blackProdDesc"));
            req.setAttribute("yellowProdDesc", bundle.getString("yellowProdDesc"));
            req.setAttribute("whitePrice", bundle.getString("whitePrice"));
            req.setAttribute("blackPrice", bundle.getString("blackPrice"));
            req.setAttribute("yellowPrice", bundle.getString("yellowPrice"));
            req.setAttribute("whiteName", bundle.getString("whiteName"));
            req.setAttribute("blackName", bundle.getString("blackName"));
            req.setAttribute("yellowName", bundle.getString("yellowName"));
        }
        req.getRequestDispatcher("WEB-INF/Products.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String wantedLang = req.getParameter("Lang");
        Cookie cookie = new Cookie("lang", wantedLang);
        resp.addCookie(cookie);
        resp.sendRedirect("./products");
    }
}
