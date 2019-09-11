package no.hvl.DAT152.Oppgave1;

import java.time.Year;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;


public class Main {

	private static TerminalInterface ti = new TerminalInterface();
	private static DAO dao = new DAO();

    public static void main(String[] args) {
        Cart cart = new Cart();
        //String lokasjonSvar = ti.query("please choose location (write number):\n1: Norway\n2: United States of America\n3: Spain");
		String locationAnswer = getLocationAnswer();
        Locale locale = new Locale(locationAnswer);
		ResourceBundle bundle = ResourceBundle.getBundle("productStrings", locale);
		cart = addToCart(bundle, cart);
		ArrayList<Product> cartList = cart.getCartList();
		for (Product product : cartList) {
			System.out.println(product.toString(bundle));
		}

		System.out.println(coyprightString());
    }


	/**
	 * @param bundle
	 * @param cart
	 * @return Cart filled with products the user chooses
	 */
	private static Cart addToCart(ResourceBundle bundle, Cart cart) {
		ArrayList<Product> prodList = dao.getAllProducts();
		System.out.println(bundle.getString("productList"));
		System.out.println("--------------------------------------------------------");
		for (Product p : prodList) {
			System.out.println("Nr: " + p.getpNo());
			System.out.println(bundle.getString(p.getpName()) + ": \n" + bundle.getString(p.getPriceInEuro()) + "\n" + bundle.getString(p.getResourceKey()));
			System.out.println("--------------------------------------------------------");
		}

		while (true) {
			String productAnswer = ti.query(bundle.getString("addToChart") + "\n" + bundle.getString("notaddAnything"));
			switch (productAnswer) {
				case "1":
					cart.addToCart(prodList.get(0));
					break;
				case "2":
					cart.addToCart(prodList.get(1));
					break;
				case "3":
					cart.addToCart(prodList.get(2));
					break;
				case "0":
					break;
				default:
					System.out.println(bundle.getString("wrongInput"));
			}
			String continueAnswer = ti.query(bundle.getString("addNewProducts"));
			if (continueAnswer.equals("y")) {

			}else if (continueAnswer.equals("n")) {
				break;
			} else {
				System.out.println(bundle.getString("yesNoError"));
			}
		}
		return cart;
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

	/**
	 * @return String representing the location chosen by the user, asks user endlessly until user types in correct input
	 */
	private static String getLocationAnswer() {
		String answer = ti.query("please choose location (write number):\n1: Norway\n2: United States of America\n3: Spain");
		while (true) {
			try {
				int number = Integer.parseInt(answer);
				if (number < 1 || number > 3) {
					answer = ti.query("DID NOT CHOOSE CORRECT NUMBER TRY AGAIN:\n" + "please choose location (write number):\n1: Norway\n2: United States of America\n3: Spain");
				} else {
					switch (number) {
						case 1:
							return "nb_NO";
						case 2:
							return "us";
						case 3:
							return "ES";
						default:
							return "something went wrong";
					}
				}
			} catch (NumberFormatException e) {
				System.out.println("Did not respond with number");
				answer = ti.query("please choose location (write number):\n1: Norway\n2: United States of America\n3: Spain");
			}
		}
	}
}