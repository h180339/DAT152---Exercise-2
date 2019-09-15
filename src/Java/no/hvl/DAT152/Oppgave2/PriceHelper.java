package no.hvl.DAT152.Oppgave2;

import no.hvl.DAT152.Oppgave1.Cart;
import no.hvl.DAT152.Oppgave1.Product;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PriceHelper {
    public static Cart getTotals(Cart cart, Locale locale) {
        ArrayList<Product> list = cart.getCartList();
        for (Product product : list) {
            ResourceBundle bundle = ResourceBundle.getBundle("productStrings", locale);
            String s = bundle.getString(product.getPriceInEuro());
            System.out.println(s);
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
