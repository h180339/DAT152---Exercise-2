package no.hvl.DAT152.Oppgave3;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.StringWriter;

public class ShortTextTag extends SimpleTagSupport {

	private static final int LENGTH = 30;
	StringWriter sw = new StringWriter();

	public void doTag() throws JspException {
		JspWriter out = getJspContext().getOut();
		try {
			getJspBody().invoke(sw);
			String input = sw.toString();
			StringBuilder stringBuilder = new StringBuilder(LENGTH + 4);
			if(input.length() >= LENGTH) {
				stringBuilder.append(input.substring(0, LENGTH));
				stringBuilder.append(" ...");
				out.print(stringBuilder.toString());
			} else {
				out.print(input);
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}