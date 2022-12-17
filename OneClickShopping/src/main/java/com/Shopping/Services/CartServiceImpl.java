package com.Shopping.Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Shopping.Exceptions.CartException;
import com.Shopping.Exceptions.CustomerException;
import com.Shopping.Exceptions.LoginException;
import com.Shopping.Exceptions.ProductException;
import com.Shopping.Model.Cart;
import com.Shopping.Model.CurrentUserSession;
import com.Shopping.Model.Customer;
import com.Shopping.Model.Products;
import com.Shopping.Repository.CartRepo;
import com.Shopping.Repository.CurrentUserSessionRepo;
import com.Shopping.Repository.CustomerRepo;
import com.Shopping.Repository.Productrepo;

@Service
public class CartServiceImpl implements CartServices {

	@Autowired
	private CustomerRepo cRepo;

	@Autowired
	private CurrentUserSessionRepo cusRepo;

	@Autowired
	private Productrepo pRepo;

	@Autowired
	private CartRepo cartRepo;

	@Override
	public Cart AddProductToCart(Integer productId, String key, Integer customerId)
			throws LoginException, CustomerException, ProductException {
		Customer customer = checkLogin(key, customerId);

		Optional<Products> opt = pRepo.findById(productId);
		if (opt.isEmpty())
			throw new ProductException("Product not Found with Id:- " + productId);
		Products product = opt.get();

		Cart cart = customer.getCart();

		Map<Products, Integer> cartMap = cart.getProducts();

		if (cartMap.containsKey(product)) {
			cartMap.put(product, cartMap.get(product) + 1);
		} else {
			cartMap.put(product, 1);
		}

		cart.setCartValue(cart.getCartValue() + product.getPrice());

		Cart savedCart = cartRepo.save(cart);

		return savedCart;
	}

	@Override
	public Cart descreaseQuantityOfProduct(Integer productId, String key, Integer customerId, Integer Quantity)
			throws LoginException, CustomerException, ProductException, CartException {
		Customer customer = checkLogin(key, customerId);

		Optional<Products> opt = pRepo.findById(productId);
		if (opt.isEmpty())
			throw new ProductException("Product not Found with Id:- " + productId);
		Products product = opt.get();

		Cart cart = customer.getCart();

		Map<Products, Integer> cartMap = cart.getProducts();

		if (cartMap.containsKey(product)) {
			Integer quan = cartMap.get(product);
			if (quan > Quantity) {
				cartMap.put(product, quan - Quantity);
				cart.setCartValue(cart.getCartValue() - (product.getPrice() * Quantity));
			} else {
				cartMap.remove(product);
				cart.setCartValue(cart.getCartValue() - (product.getPrice() * quan));
			}
			Cart savedCart = cartRepo.save(cart);
			return savedCart;
		} else {
			throw new CartException("Product Not present In cart");
		}
	}

	@Override
	public Cart removeProductFromCart(Integer productId, String Key, Integer customerId)
			throws LoginException, CustomerException, ProductException, CartException {
		Customer customer = checkLogin(Key, customerId);

		Optional<Products> opt = pRepo.findById(productId);
		if (opt.isEmpty())
			throw new ProductException("Product not Found with Id:- " + productId);
		Products product = opt.get();

		Cart cart = customer.getCart();

		Map<Products, Integer> cartMap = cart.getProducts();
		
		if(cartMap.containsKey(product)) {
			Integer quantity = cartMap.get(product);
			
			cartMap.remove(product);
			cart.setCartValue(cart.getCartValue()-(product.getPrice()*quantity));
			
			Cart savedCart = cartRepo.save(cart);
			
			return savedCart;
			
		}else {
			throw new CartException("Product Not Found with Id:- "+productId);
		}

	}

	@Override
	public Cart emptycart(String key, Integer customerId) throws LoginException, CustomerException {
		Customer customer = checkLogin(key, customerId);
		
		Cart cart= customer.getCart();
		
		cart.setProducts(new HashMap<>());
		cart.setCartValue(0);
		Cart savedCart= cartRepo.save(cart);
		
		return savedCart;
	}

	@Override
	public List<Products> getAllProductInCart(Integer customerId, String key) throws LoginException, CustomerException, CartException {
		Customer customer = checkLogin(key, customerId);
		
		List<Products> productList=new ArrayList<>();
		
		Cart cart= customer.getCart();
		Map<Products, Integer> cartMap= cart.getProducts();
		if(cartMap.size()==0) throw new CartException("No product Found In cart....");
		
		for(Map.Entry<Products, Integer> map:cartMap.entrySet()) {
			productList.add(map.getKey());
		}
		
		return productList;
	}

	@Override
	public Integer getCartValue(Integer customerId, String key) throws LoginException, CustomerException {
		Customer customer = checkLogin(key, customerId);
		
		return (int)customer.getCart().getCartValue();
	}

	
	
	
	
	public Customer checkLogin(String key, Integer customerId) throws LoginException, CustomerException {
		Optional<Customer> opt = cRepo.findById(customerId);
		if (opt.isEmpty())
			throw new CustomerException("No customer Found with id:- " + customerId);

		Customer customer = opt.get();
		CurrentUserSession cus = cusRepo.findByUuid(key);

		if (cus == null)
			throw new LoginException("Invalid Current Key");
		if (cus.getUserId() != customer.getCustomerId())
			throw new LoginException("Please Login first.....");

		return customer;

	}

}
