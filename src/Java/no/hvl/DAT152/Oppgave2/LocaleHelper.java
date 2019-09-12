package no.hvl.DAT152.Oppgave2;

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
}
