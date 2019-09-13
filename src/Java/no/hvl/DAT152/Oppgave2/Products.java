package no.hvl.DAT152.Oppgave2;

import no.hvl.DAT152.Oppgave1.Product;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

@WebServlet(name = "Products", urlPatterns = "/products")
public class Products extends HttpServlet {

    private NewDAO dao = new NewDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        Cookie langCookie = CookieHelper.findCookie(cookies, "lang");
        Locale locale = req.getLocale();
        ResourceBundle bundle = ResourceBundle.getBundle("productStrings", locale);
        ArrayList<Product> prods = dao.getAllProducts(getServletContext());
        setImgAtr(req, prods);

        if (langCookie != null) {
            locale = new Locale(langCookie.getValue());
            req.setAttribute("langLocale", locale);

        } else {
            req.setAttribute("langLocale", locale);
        }
        req.getRequestDispatcher("WEB-INF/Products.jsp").forward(req, resp);
    }

    private void setImgAtr(HttpServletRequest req, ArrayList<Product> prods) {
        for (int i = 0; i < prods.size(); i++) {
            System.out.println("img" +i);

            req.setAttribute("img" + i, prods.get(i).getImageFile());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String wantedLang = req.getParameter("Lang");
        String cup = req.getParameter("cup");
        Cookie cookie = new Cookie("lang", wantedLang);
        resp.addCookie(cookie);
        resp.sendRedirect("./products");
    }
}
