package com.gabby.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabby.Exception.OrderException;
import com.gabby.Service.OrderService;
import com.gabby.model.Orders;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/orders")
	public ResponseEntity<Orders> placeOrderHandler(@RequestBody Orders orders)throws OrderException{
		Orders orders2 = orderService.addOrder(orders);
		
		return new ResponseEntity<Orders>(orders2,HttpStatus.OK);
	}
	
}
