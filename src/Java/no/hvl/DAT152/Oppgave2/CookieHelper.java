package no.hvl.DAT152.Oppgave2;

import javax.servlet.http.Cookie;

public class CookieHelper {

    public CookieHelper() {
    }

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
