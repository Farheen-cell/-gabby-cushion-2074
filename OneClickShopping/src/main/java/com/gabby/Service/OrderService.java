package com.gabby.Service;

import java.time.LocalDate;
import java.util.List;

import com.gabby.Exception.OrderException;
import com.gabby.model.Orders;


public interface OrderService {
	
	public Orders addOrder(Orders orders)throws OrderException;
	
	public Orders updateOrder(Orders orders)throws OrderException;
	
	public Orders removeOrder(Orders orders)throws OrderException;
	
	public Orders ViewOrder(Orders orders)throws OrderException;

	public List<Orders> viewAllOrders(LocalDate date) throws OrderException;
	
	public List<Orders> viewAllOrderByLocation(String address)throws OrderException;
	
	public List<Orders> viewOrderByUserId(String userId) throws OrderException;
	
}
