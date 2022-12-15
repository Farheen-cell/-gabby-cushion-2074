package com.gabby.Service;

import java.time.LocalDate;
//import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabby.Exception.OrderException;
import com.gabby.model.Orders;
import com.gabby.repository.OrderRepo;
//import com.gabby.repository.ProductDao;
@Service
public class OrderServiceImlp implements OrderService{
	
	@Autowired
	private OrderRepo orderRepo;
	
	@Override
	public Orders addOrder(Orders orders) throws OrderException {
		Optional<Orders> optional = orderRepo.findById(orders.getCustomer().getCustomerId());
		if(optional.isEmpty()) {
			throw new OrderException("order not found");
		}else {
			Orders orders2 = orderRepo.save(orders);
			orders2.setOrderDate(LocalDate.now());
			orders2.setOrderStatus("Ok");
			return orders2;
		}
		
		
	}

	@Override
	public Orders updateOrder(Orders orders) throws OrderException {
		Optional<Orders> optional = orderRepo.findById(orders.getOrderId());
		if(optional.isPresent()) {
			Orders updateOrder = orderRepo.save(orders);
			return updateOrder;
		}else {
			throw new OrderException("no order found to update...");
		}
	}

	@Override
	public Orders removeOrder(Orders orders) throws OrderException {
		Optional<Orders> opt = orderRepo.findById(orders.getOrderId());
		
		if(opt.isPresent()) {
			Orders existingOrder = opt.get();
			orderRepo.delete(existingOrder);
			return existingOrder;
		}else {
			throw new OrderException("no data found to delete...");
		}
	}

	@Override
	public Orders ViewOrder(Orders orders) throws OrderException {
		Optional<Orders> optional = orderRepo.findById(orders.getOrderId());
		if(optional.isPresent()) {
			Orders orders2 = optional.get();
			return orders2;
		}else {
			throw new OrderException("no order found...");
		}
	}

	@Override
	public List<Orders> viewAllOrders(LocalDate date) throws OrderException {
		List<Orders> list = orderRepo.getOrderDate(date);
		if(list.isEmpty()) {
			throw new OrderException("no list found");
		}else {
			
			return list;
		}
	}

	@Override
	public List<Orders> viewAllOrderByLocation(String address) throws OrderException {
		List<Orders> list = orderRepo.getviewAllOrderByLocation(address);
		if(list.isEmpty()) {
			throw new OrderException("no list found");
		}else {
			
			return list;
		}
	}

	@Override
	public List<Orders> viewOrderByUserId(String userId) throws OrderException {
		List<Orders> list = orderRepo.getviewAllOrderByLocation(userId);
		if(list.isEmpty()) {
			throw new OrderException("no list found");
		}else {
			
			return list;
		}
	}
	
	
	
	
}
