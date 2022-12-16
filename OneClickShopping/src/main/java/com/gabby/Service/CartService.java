package com.gabby.services;

import java.util.List;

import com.gabby.exceptions.CartException;
import com.gabby.exceptions.CustomerException;
import com.gabby.exceptions.LoginException;
import com.gabby.exceptions.ProductException;
import com.gabby.model.Cart;
import com.gabby.shopDTO.ProductDTO;

public interface CartService {

	public String deleteallproducts(String key) throws ProductException, CartException, LoginException, CustomerException;

	public List<ProductDTO> viewallproducts(String key) throws LoginException, CustomerException, ProductException, CartException;

	public Cart addproduct(Integer productId, Integer quantity, String key) throws ProductException, LoginException, CustomerException, CartException;

	public Cart deleteproduct(Integer productId, String key) throws LoginException, CustomerException, CartException, ProductException;

	public Cart udpateproductquantity(String key, Integer productId, Integer quantity) throws CartException, LoginException, CustomerException, ProductException;
}
