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

	public void setCartList(ArrayList<Product> cartList) {
		this.cartList = cartList;
	}

	public void addToCart(Product product) {
		for(Product p : cartList) {
			if(p.compareTo(product)) {
				p.setAmount(p.getAmount() + 1);
				return;
			}
		}
		cartList.add(product);

	}
}