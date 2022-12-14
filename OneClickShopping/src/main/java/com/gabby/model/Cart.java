package com.gabby.model;

import java.util.List;

public class Cart {

	private Integer cartId;
	
	private Customer customer;
	
	private List<Product> ltproduct;
	
	

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", customer=" + customer + ", ltproduct=" + ltproduct + "]";
	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Product> getLtproduct() {
		return ltproduct;
	}

	public void setLtproduct(List<Product> ltproduct) {
		this.ltproduct = ltproduct;
	}
	
	
	
	
}
