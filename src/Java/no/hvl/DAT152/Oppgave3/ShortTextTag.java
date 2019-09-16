package no.hvl.DAT152.Oppgave3;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.StringWriter;


/**
 * Class representing shortText custom JSP tag
 *
 * @author Gruppe 5
 * @version 1.0.0
 */
public class ShortTextTag extends SimpleTagSupport {

    private static final int LENGTH = 30;
    StringWriter sw = new StringWriter();

    /**
     * Takes the string from the body of the tag and shorten it and adds "..." to the end of the string
     */
    public void doTag() {
        JspWriter out = getJspContext().getOut();
        try {
            getJspBody().invoke(sw);
            String input = sw.toString();
            StringBuilder stringBuilder = new StringBuilder(LENGTH + 4);
            if (input.length() >= LENGTH) {
                stringBuilder.append(input, 0, LENGTH);
                stringBuilder.append(" ...");
                out.print(stringBuilder.toString());
            } else {
                out.print(input);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}