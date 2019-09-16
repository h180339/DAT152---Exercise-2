package no.hvl.DAT152.Oppgave1;

import java.util.ArrayList;

/**
 * A class representing a cart where you can add products
 *
 * @author Gruppe 5
 * @version 1.0.0
 */
public class Cart {

    private ArrayList<Product> cartList;
    private Double totalAmout;

    /**
     * Constructs a new Cart
     */
    public Cart() {
        this.cartList = new ArrayList<>();
        this.totalAmout = 0.0;
    }

    /**
     * @return list of products that the cart contains
     */
    public ArrayList<Product> getCartList() {
        return cartList;
    }

    /**
     * Sets the product list in the cart object
     *
     * @param cartList
     */
    public void setCartList(ArrayList<Product> cartList) {
        this.cartList = cartList;
    }

    /**
     * @param product Adds a product to the list of products in the cart
     */
    public void addToCart(Product product) {
        for (Product p : cartList) {
            if (p.compareTo(product)) {
                p.setAmount(p.getAmount() + 1);
                return;
            }
        }
        cartList.add(product);
    }

    /**
     * @return the total amount the the cart is worth
     */
    public Double getTotalAmout() {
        return totalAmout;
    }

    /**
     * Sets the total amount the cart is worth
     *
     * @param totalAmout Sets
     */
    public void setTotalAmout(Double totalAmout) {
        this.totalAmout = totalAmout;
    }

    /**
     * Adds to the total amount the cart is worth
     *
     * @param add
     */
    public void addToTotalAmount(Double add) {
        this.totalAmout += add;
    }
}