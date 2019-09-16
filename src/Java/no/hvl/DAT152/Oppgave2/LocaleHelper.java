package no.hvl.DAT152.Oppgave2;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Class that helps servlets handle what language to show
 *
 * @author Gruppe 5
 * @version 1.0.0
 */
public class LocaleHelper {


    /**
     * @param req
     * @return cookie representing the language of the page
     */
	public static String getLang(HttpServletRequest req) {
		Cookie[] cookies = req.getCookies();
		Cookie langCookie = CookieHelper.findCookie(cookies, "lang");
		return langCookie != null ? langCookie.getValue() : null;
	}

    /**
     * Sets the wanted language for the page
     *
     * @param langCookie
     * @param locale
     * @param req
     * @return the locale of the page
     */
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
