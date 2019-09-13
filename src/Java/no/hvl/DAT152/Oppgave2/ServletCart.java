package no.hvl.DAT152.Oppgave2;

import no.hvl.DAT152.Oppgave1.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ResourceBundle;

@WebServlet(name = "Cart", urlPatterns = "/cart")
public class ServletCart extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ResourceBundle bundle = LocaleHelper.getBundle(req);

		req.setAttribute("locale", LocaleHelper.getLocaleString(req));

		HttpSession session = req.getSession(false);
		Cart cart = (Cart) session.getAttribute("cart");

		if(cart != null && !cart.getCartList().isEmpty()) {
			req.setAttribute("cartEmpty", false);
			req.setAttribute("cart", cart.getCartList());
		} else {
			req.setAttribute("cartEmpty", true);
		}

		//Display page.
		req.getRequestDispatcher("WEB-INF/Cart.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
