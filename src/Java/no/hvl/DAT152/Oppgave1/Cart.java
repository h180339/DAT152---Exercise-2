package no.hvl.DAT152.Oppgave1;

import java.util.ArrayList;

/**
 * A class representing a cart where you can add products
 */
public class Cart {

	private ArrayList<Product> cartList;
	private Double totalAmout;

	public Cart() {
		this.cartList = new ArrayList<>();
		this.totalAmout = 0.0;
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

	public Double getTotalAmout() {
		return totalAmout;
	}

	public void setTotalAmout(Double totalAmout) {
		this.totalAmout = totalAmout;
	}
	public void addToTotalAmount(Double add) {
		this.totalAmout += add;
	}
}