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

@WebServlet(name = "Home", urlPatterns = "/home")
public class Home extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String langCookie = LocaleHelper.getLang(req);
		Locale locale = req.getLocale();
		if (langCookie != null) {
			String [] location = langCookie.split("_");
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

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String wantedLang = req.getParameter("Lang");
		Cookie cookie = new Cookie("lang", wantedLang);
		resp.addCookie(cookie);
		resp.sendRedirect("./home");
	}
}
