package com.Shopping.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Shopping.Exceptions.AddressException;
import com.Shopping.Exceptions.CartException;
import com.Shopping.Exceptions.CustomerException;
import com.Shopping.Exceptions.LoginException;
import com.Shopping.Exceptions.OrderException;
import com.Shopping.Model.Order;
import com.Shopping.Services.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService oService;
	
	
	@PutMapping("/placeOrder/{customerId}/{key}")
	public ResponseEntity<Order> placeOrderHandler(@PathVariable Integer customerId,@PathVariable String key) 
			throws LoginException, CustomerException, OrderException, CartException, AddressException{
		
		Order placedOrder= oService.placeOrder(customerId, key);
		
		return new ResponseEntity<Order>(placedOrder,HttpStatus.ACCEPTED);
	} 
	
	@GetMapping("/getOrder/{orderId}/{customerId}/{key}")
	public ResponseEntity<Order> getOrderByIdHandler(@PathVariable Integer orderId,@PathVariable Integer customerId,@PathVariable String key) 
			throws LoginException, CustomerException, OrderException{
		
		Order order = oService.getOrderById(orderId, customerId, key);
		
		return new ResponseEntity<Order>(order,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getALlOrder/{customerId}/{key}")
	public ResponseEntity<List<Order>> getAllOrderHandler(@PathVariable Integer customerId,@PathVariable String key) throws LoginException, CustomerException, OrderException{
		
		List<Order> orderList = oService.getAllOrder(customerId, key);
		
		return new ResponseEntity<List<Order>>(orderList,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/cancelOrder/{orderId}")
	public ResponseEntity<String> cancelOrderHandler(@PathVariable Integer orderId,@RequestParam Integer customerId,@RequestParam String key) 
			throws LoginException, CustomerException, OrderException{
		
		String message = oService.cancelOrder(orderId, customerId, key);
		
		return new ResponseEntity<String>(message,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deleteOrder/{orderId}")
	public ResponseEntity<String> deleteOrderHandler(@PathVariable Integer orderId,@RequestParam Integer customerId,@RequestParam String key) 
			throws LoginException, CustomerException, OrderException{
		
		String message =oService.deleteOrder(orderId, customerId, key);
	
		return new ResponseEntity<String>(message,HttpStatus.ACCEPTED);
	}
	
	
}
