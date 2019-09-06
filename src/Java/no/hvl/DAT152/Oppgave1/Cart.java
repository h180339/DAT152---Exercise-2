package no.hvl.DAT152.Oppgave1;

import java.util.ArrayList;

/**
 * A class representing a cart where you can add products
 */
public class Cart {

    private ArrayList<Product> cartList;

    public Cart() {
        this.cartList = new ArrayList<>();
    }

    public ArrayList<Product> getCartList() {
        return cartList;
    }

    public boolean addToCart(Product product) {
        return cartList.add(product);
    }
}
