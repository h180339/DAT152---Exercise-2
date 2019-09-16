package no.hvl.DAT152.Oppgave3;

import no.hvl.DAT152.Oppgave1.RomanNumber;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.StringWriter;
import java.time.Year;


/**
 * Class representing a custom copyright JSP tag
 *
 * @author Gruppe 5
 * @version 1.0.0
 */
public class CopyrightTag extends SimpleTagSupport {

	private static final int LENGTH = 30;
	StringWriter sw = new StringWriter();

	/**
	 * Shows current year in roman numerals
	 */
	public void doTag() {
		JspWriter out = getJspContext().getOut();
		try {
			int year = Year.now().getValue();

			String romanYear = RomanNumber.toRoman(year);

			out.write("© since MMVIII - " + romanYear + " HVL.");
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}