package com.gabby.Service;

import com.gabby.Exception.CartException;
import com.gabby.model.Cart;
import com.gabby.dto.ProductDto;
import java.util.List;

public interface CartService {

	
	public String deleteallproducts(String key) throws CartException;

	public List<ProductDto> viewallproducts(String key) throws CartException;

	public Cart addproduct(Integer productId, Integer quantity, String key) throws CartException;

	public Cart deleteproduct(Integer productId, String key)throws CartException;

	public Cart udpateproductquantity(String key, Integer productId, Integer quantity) throws CartException;

}
