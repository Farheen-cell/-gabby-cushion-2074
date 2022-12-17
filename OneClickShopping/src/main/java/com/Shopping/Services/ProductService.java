package com.Shopping.Services;

import java.util.List;

import com.Shopping.Exceptions.LoginException;
import com.Shopping.Exceptions.SellerException;
import com.Shopping.Exceptions.ProductException;
import com.Shopping.Model.Seller;
import com.Shopping.Model.Products;

public interface ProductService {

	public Products AddProduct(Products sproduct,String key,Integer sellerId) throws LoginException,SellerException;
	
	public List<Products> viewAllProductById(Integer sellerId,String key) throws ProductException,SellerException,LoginException;
	
	public Products viewProductById(Integer sProcutId,String key,Integer sellerId) throws ProductException,LoginException,SellerException;
	
	public List<Products> viewByCategory(String Category,String key,Integer sellerId) throws ProductException,LoginException,SellerException;
	
	public String removeSellerProduct(Integer sproductId,String key,Integer sId) throws LoginException,SellerException,ProductException;
	
	public Products updateProduct(Integer sellerId,String key,Products sProduct)throws LoginException,SellerException,ProductException;
}
