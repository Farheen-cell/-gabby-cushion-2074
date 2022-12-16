package com.masai.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.dto.ProductDto;
import com.masai.exception.AddressException;
import com.masai.exception.CartException;
import com.masai.exception.CustomerException;
import com.masai.exception.LoginException;
import com.masai.exception.OrderExcetion;
import com.masai.exception.ProductException;
import com.masai.model.Address;
import com.masai.model.Cart;
import com.masai.model.Customer;
import com.masai.model.Login;
import com.masai.model.Orders;
import com.masai.model.Product;
import com.masai.service.AddressService;
import com.masai.service.CartService;
import com.masai.service.CustomerService;
import com.masai.service.LoginService;
import com.masai.service.OrderService;
import com.masai.service.ProductService;


@RestController
@RequestMapping("/users")
public class UserController {

	
	
	@Autowired
	private CustomerService cus;
	
	
	@Autowired
	private LoginService login;
	
	@Autowired
	private AddressService ads;
	
	@Autowired
	private CartService car;
	
	@Autowired
	private OrderService odd;
	
	@Autowired
	private ProductService prod;
	
	
	@PostMapping("/addCustomer")
	 public ResponseEntity<Customer> addcustomer(@Valid @RequestBody Customer customer) throws  CustomerException
	 {
		 Customer addCustomer = cus.addCustomer(customer);
		 
		 return new ResponseEntity<Customer>(addCustomer, HttpStatus.CREATED);
	 }
	
	
	@PutMapping("/updacustomer/{key}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("key") String key, @RequestBody Customer customer) throws LoginException,CustomerException
	{
		Customer update = cus.updateCust(customer, key);
		
		
		return new ResponseEntity<Customer>(update, HttpStatus.CREATED);
	}
	
	
	
	@DeleteMapping("/delAccount{key}")
	public ResponseEntity<Customer> delAccount(@PathVariable("key") String key, @RequestBody Customer customer) throws LoginException, CustomerException
	{
		
		Customer del = cus.removeCustomer(customer, key);
		
		return new ResponseEntity<Customer>(del, HttpStatus.OK);
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@Valid @RequestBody Login log) throws CustomerException, LoginException
	{
		
		String s = login.logIntoAccount(log);
		
		return new ResponseEntity<String>(s, HttpStatus.OK);
	}
	
	@DeleteMapping("/logout")
	public ResponseEntity<String> logot(@RequestParam String key) throws CustomerException , LoginException
	{
		String s = login.logOutFromAccount(key);
		return new ResponseEntity<String>(s, HttpStatus.OK);
	}
	
	
	@PostMapping("/address")
    public ResponseEntity<Address> addaddress(@RequestBody Address address, @RequestParam String key) throws AddressException, LoginException
    {
		Address s = ads.addAddress(address, key);
		
		return new ResponseEntity<Address>(s, HttpStatus.OK);
    }
	
	@PutMapping("/address")
    public ResponseEntity<Address> updateAdd(@RequestBody Address address, @RequestParam String key) throws AddressException, LoginException
    {
		Address s = ads.updateAddress(address, key);
		
		return new ResponseEntity<Address>(s, HttpStatus.OK);
    }
	
	@DeleteMapping("/address{delid}")
	public ResponseEntity<String> deladdres(@PathVariable("delid") Integer de, @RequestParam String key) throws LoginException ,CustomerException
	{
		String s = ads.removeAddress(de, key);
		
		return new ResponseEntity<String>(s, HttpStatus.OK);
	}
	
	
	
	@PostMapping("/cadd")
	public ResponseEntity<Cart> addtoCart(@RequestParam Integer productId, @RequestParam Integer quantity, @RequestParam String key) throws CartException,LoginException,ProductException
	{
		
		Cart cartIteam = car.addProductToCart(productId, quantity, key);
		
		return new ResponseEntity<Cart>(cartIteam, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/cart/r")
	public ResponseEntity<List<ProductDto>> removefrom(@RequestParam Integer productid,@RequestParam  String key) throws CartException, LoginException
	{
		List<ProductDto> list = car.removeProductfromCart(productid, key);
		
		return new ResponseEntity<List<ProductDto>>(list, HttpStatus.OK);
	}
	
	
	@GetMapping("/getprod")
	public ResponseEntity<List<ProductDto>> getallcart(@RequestParam String key) throws CartException,LoginException
	{
		List<ProductDto> s = car.viewAllProducts(key);
		
		return new ResponseEntity<List<ProductDto>>(s, HttpStatus.OK);
	}
	
	@PostMapping("/orders")
	public ResponseEntity<Orders> addOrder(@RequestBody Orders order, @RequestParam String key) throws OrderExcetion, LoginException
	{
		Orders added = odd.addOrder(order, key);
		
		return new ResponseEntity<Orders>(added,HttpStatus.OK);
	}
	
	@PutMapping("/orderup")
	public ResponseEntity<Orders> updateOrder(@RequestBody Orders order, @RequestParam String key) throws LoginException,OrderExcetion
	{
		
		Orders s = odd.updateCustomer(order, key);
		
		return new ResponseEntity<Orders>(s,HttpStatus.OK);
		
	}
	
	
	
	@DeleteMapping("/delt{orderid}")
	public ResponseEntity<Orders> removeorder(@PathVariable("orderid") Integer orderId, @RequestParam String uuid) throws OrderExcetion, LoginException
	{
		Orders delt = odd.removeOrder(orderId, uuid);
		
		return new ResponseEntity<Orders>(delt, HttpStatus.OK);
	}
	
	@GetMapping("/allorder/{date}")
	public ResponseEntity<List<Orders>> georderbydate(@PathVariable("data") LocalDate date) throws OrderExcetion
	{
		
		   List<Orders> s= odd.viewallOrderByDate(date);
		   
		   return new ResponseEntity<List<Orders>>(s, HttpStatus.OK);
		   
	}
	
	@GetMapping("/vieworder")
     public ResponseEntity<Orders> viewOrder(@RequestParam Integer orderId) throws OrderExcetion
     
     {
		Orders s = odd.viewOrder(orderId);
		
		return new ResponseEntity<Orders>(s,HttpStatus.OK);
     }
	
//	@GetMapping
//	public ResponseEntity<List<Orders>> getAllorderuserid(@RequestParam String userid) throws OrderExcetion
//	{
//		
//	}
	
	
	@GetMapping("/allproduct")
	public ResponseEntity<List<Product>> getallprod()throws ProductException
	{
		List<Product> allpr = prod.viewAllproduct();
		
		return new ResponseEntity<List<Product>>(allpr,HttpStatus.OK);
	}
	
	
	
	@GetMapping("/p/c/{catname}")
	public ResponseEntity<List<Product>> GetprodtByCat(@PathVariable("catname") String cat) throws ProductException
	{
		List<Product> s = prod.viewProudctbyCategory(cat);
		
		return new ResponseEntity<List<Product>>(s,HttpStatus.OK);
	}
	
	
	
	
	
	
}
