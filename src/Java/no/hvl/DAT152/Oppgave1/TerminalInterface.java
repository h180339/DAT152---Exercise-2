package no.hvl.DAT152.Oppgave1;

import java.util.Scanner;

/**
 * User interface implemented as a console terminal.
 */
public class TerminalInterface {

	/**
	 * Empty constructor
	 */
	public TerminalInterface() {

	}

	/**
	 * @param s string to be written
	 */
	public void writeLine(String s) {
		System.out.println(s);
	}

	/**
	 * @param s string to be written
	 * @return the next line is returned
	 */
	public String query(String s) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(s);
		return scanner.nextLine();
	}

}
