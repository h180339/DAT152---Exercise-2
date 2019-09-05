package no.hvl.DAT152.Oppgave1;

import java.util.ResourceBundle;

public class Main {

    public static void main(String[] args) {
        ResourceBundle stringsBundle;
		TerminalInterface i = new TerminalInterface();

		i.writeLine("Virker dette?");
		String s = i.query("Skriv en streng:");
		System.out.println(s);
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
}