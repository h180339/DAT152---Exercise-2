package no.hvl.DAT152.Oppgave1;

import java.time.Year;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;


public class Main {

    public static void main(String[] args) {
        DAO dao = new DAO();
        Locale locale = new Locale("ES");
		ResourceBundle bundle = ResourceBundle.getBundle("productStrings", locale);
		ArrayList<Product> prodList = dao.getAllProducts();
		for (Product product : prodList) {
			System.out.println(bundle.getString(product.getResourceKey()));
		}
		System.out.println(coyprightString());
    }


	/**
	 * @param input the input string
	 * @param length the max lenght before the string is shortened
	 * @return a shortened string
	 *
	 * A method that returns a short string.
	 */
	private static String shortText(String input, int length) {
		StringBuilder stringBuilder = new StringBuilder(length + 4);
		if(input.length() >= length) {
			stringBuilder.append(input.substring(0, length));
			stringBuilder.append(" ...");
			return stringBuilder.toString();
		} else {
			return input;
		}
	}

	/**
	 * @return Returns a string with the correct roman numerals for the year 2008 - current local year.
	 */
	private static String coyprightString() {
		int year = Year.now().getValue();

		String romanYear = (String) RomanNumber.toRoman(year);

		return "© since MMVIII - " + romanYear + " HVL.";
	}
}