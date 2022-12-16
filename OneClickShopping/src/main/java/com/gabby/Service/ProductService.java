package com.gabby.services;

import java.util.List;

import com.gabby.exceptions.AdminException;
import com.gabby.exceptions.LoginException;
import com.gabby.exceptions.ProductException;
import com.gabby.model.Product;

public interface ProductService {

	public List<Product> viewallProducts() throws ProductException;

	public Product insertProduct(String key, Product product) throws LoginException, AdminException;

	public Product updateProduct(String key, Product product) throws LoginException, ProductException, AdminException;

	public Product viewProduct(Integer productId) throws ProductException;

	public List<Product> viewProductByCategory(String category_Name) throws ProductException;

	public String removeProduct(String key, Integer product_Id) throws LoginException, ProductException, AdminException;

}
