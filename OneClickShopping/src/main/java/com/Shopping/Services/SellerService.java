package com.Shopping.Services;

import com.Shopping.Exceptions.LoginException;
import com.Shopping.Exceptions.SellerException;
import com.Shopping.Model.Seller;

public interface SellerService {

	public Seller insertSeller(Seller seller) throws SellerException;

	public String deleteSeller(int sid, String Key) throws SellerException, LoginException;

	public Seller updateName(int sid, String key, String sellerName) throws SellerException, LoginException;
}
