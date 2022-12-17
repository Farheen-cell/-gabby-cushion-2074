package com.Shopping.Services;

import java.util.List;

import com.Shopping.Exceptions.CartException;
import com.Shopping.Exceptions.CustomerException;
import com.Shopping.Exceptions.LoginException;
import com.Shopping.Exceptions.ProductException;
import com.Shopping.Model.Cart;
import com.Shopping.Model.Products;

public interface CartServices {

	public Cart AddProductToCart(Integer productId,String key,Integer customerId)
			throws LoginException,CustomerException,ProductException;
	
	public Cart descreaseQuantityOfProduct(Integer productId,String key,Integer customerId,Integer Quantity)
			throws LoginException,CustomerException,ProductException,CartException;
	
	public Cart removeProductFromCart(Integer productId,String Key,Integer customerId)
			throws LoginException,CustomerException,ProductException,CartException;
	
	public Cart emptycart(String key,Integer customerId)
			throws LoginException,CustomerException,CartException;
	
	public List<Products> getAllProductInCart(Integer customerId,String key)
			throws LoginException,CustomerException,CartException;
	
	public Integer getCartValue(Integer customerId,String key)
			throws LoginException,CustomerException;
	
	
}
