package no.hvl.DAT152.Oppgave2;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleHelper {

	public static ResourceBundle getBundle(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		Locale locale = null;
		if(session != null) {
			locale = (Locale) session.getAttribute("language");
		}
		if(locale != null) {
			return ResourceBundle.getBundle("productStrings", locale);
		}
		locale = req.getLocale();
		return ResourceBundle.getBundle("productStrings", locale);
	}

	public static String getLocaleString(HttpServletRequest req) {
		return req.getLocale().toString();
	}

	public static String getLang(HttpServletRequest req) {
		Cookie[] cookies = req.getCookies();
		Cookie langCookie = CookieHelper.findCookie(cookies, "lang");
		return langCookie != null ? langCookie.getValue() : null;
	}

	public static Locale setLocale(String langCookie, Locale locale, HttpServletRequest req) {
		if (langCookie != null) {
			String [] location = langCookie.split("_");
			locale = new Locale(location[0], location[1]);
			req.setAttribute("langLocale", locale);
		} else {
			req.setAttribute("langLocale", locale);
		}
		return locale;
	}
}
