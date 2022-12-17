package com.Shopping.Services;

import java.util.List;

import com.Shopping.Exceptions.AddressException;
import com.Shopping.Exceptions.CartException;
import com.Shopping.Exceptions.CustomerException;
import com.Shopping.Exceptions.LoginException;
import com.Shopping.Exceptions.OrderException;
import com.Shopping.Model.Order;

public interface OrderService {

	public Order placeOrder(Integer customerId,String key)throws LoginException,CustomerException,OrderException ,CartException,AddressException;
	
	public Order getOrderById(Integer orderId,Integer customerId,String key)throws LoginException,CustomerException,OrderException;
	
	public List<Order> getAllOrder(Integer customerId,String key)throws LoginException,CustomerException,OrderException;
	
	public String cancelOrder(Integer orderId,Integer customerId,String key)throws LoginException,CustomerException,OrderException;
	
	public String deleteOrder(Integer orderId,Integer customerId,String key)throws LoginException,CustomerException,OrderException;
}
