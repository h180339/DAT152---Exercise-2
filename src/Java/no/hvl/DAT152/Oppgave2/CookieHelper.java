package no.hvl.DAT152.Oppgave2;

import javax.servlet.http.Cookie;


/**
 * Class that helps servlets handle cookies
 *
 * @author Gruppe 5
 * @version 1.0.0
 */
public class CookieHelper {

    /**
     * Constructs a CookieHelper
     */
    public CookieHelper() {
    }

    /**
     * Finds a cookie in the array passed in
     *
     * @param cookies
     * @param lang
     * @return cookie that matches lang, else it returns null
     */
    public static Cookie findCookie(Cookie[] cookies, String lang) {

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if(lang.equals(cookie.getName())) {
                    return cookie;
                }
            }
        }
        return null;
    }


}
