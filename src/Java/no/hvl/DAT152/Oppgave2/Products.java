package no.hvl.DAT152.Oppgave2;

import no.hvl.DAT152.Oppgave1.Cart;
import no.hvl.DAT152.Oppgave1.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

@WebServlet(name = "Products", urlPatterns = "/products")
public class Products extends HttpServlet {

    private NewDAO dao = new NewDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<Product> prods = dao.getAllProducts(getServletContext());
        setImgAtr(req, prods);
        String langCookie = LocaleHelper.getLang(req);
        Locale locale = req.getLocale();
        if (langCookie != null) {
            locale = new Locale(langCookie);
            req.setAttribute("langLocale", locale);
        } else {
            req.setAttribute("langLocale", locale);
        }
        req.getRequestDispatcher("WEB-INF/Products.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String wantedLang = req.getParameter("Lang");
        if (wantedLang == null) {
            String langCookie = LocaleHelper.getLang(req);
            Locale locale = req.getLocale();
            if (langCookie != null) {
                Cookie cookie = new Cookie("lang", langCookie);
                resp.addCookie(cookie);
            } else {
                req.setAttribute("langLocale", locale);
            }
        } else {
            Cookie cookie = new Cookie("lang", wantedLang);
            resp.addCookie(cookie);
        }
        String cup = req.getParameter("cup");
        HttpSession session = req.getSession(false);
        Cart cart;
        if (session.getAttribute("cart") == null) {
            cart = new Cart();
            if (cup != null) {
                cart.addToCart(getProduct(cup));
                session.setAttribute("cart", cart);
            }
        } else {
            cart = (Cart) session.getAttribute("cart");
            if (cup != null) {
                cart.addToCart(getProduct(cup));
                session.setAttribute("cart", cart);
            }
        }
        resp.sendRedirect("./products");
    }

    private Product getProduct(String cupName) {
        ArrayList<Product> prods = dao.getAllProducts(getServletContext());
        for (Product prod : prods) {
            if (prod.getpName().equals(cupName)) {
                return prod;
            }
        }
        return null;
    }

    private void setImgAtr(HttpServletRequest req, ArrayList<Product> prods) {
        for (int i = 0; i < prods.size(); i++) {
            req.setAttribute("img" + i, prods.get(i).getImageFile());
        }
    }
}

