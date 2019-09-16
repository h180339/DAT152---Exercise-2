package no.hvl.DAT152.Oppgave2;

import no.hvl.DAT152.Oppgave1.Cart;
import no.hvl.DAT152.Oppgave1.Product;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Class that helps servlets handle prices in a cart object
 *
 * @author Gruppe 5
 * @version 1.0.0
 */
public class PriceHelper {

    /**
     * @param cart
     * @param locale
     * @return The total amount the cart is worth
     */
    public static Cart getTotals(Cart cart, Locale locale) {
        ArrayList<Product> list = cart.getCartList();
        for (Product product : list) {
            ResourceBundle bundle = ResourceBundle.getBundle("productStrings", locale);
            String s = bundle.getString(product.getPriceInEuro());
            Pattern p = Pattern.compile("[0-9]*\\.?\\,?[0-9]+");
            Matcher m = p.matcher(s);
            while (m.find()) {
                product.setTotalPrice(Double.parseDouble(m.group().replace(",", ".")) * product.getAmount());
            }
        }
        for (Product product : list) {
            cart.addToTotalAmount(product.getTotalPrice());
        }
        cart.setCartList(list);

        return cart;
    }
}
