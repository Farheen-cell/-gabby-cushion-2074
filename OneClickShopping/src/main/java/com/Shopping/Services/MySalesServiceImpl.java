package com.Shopping.Services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Shopping.Exceptions.AdminException;
import com.Shopping.Exceptions.CustomerException;
import com.Shopping.Exceptions.LoginException;
import com.Shopping.Exceptions.OrderException;
import com.Shopping.Model.Admin;
import com.Shopping.Model.CurrentUserSession;
import com.Shopping.Model.Customer;
import com.Shopping.Model.Order;
import com.Shopping.Repository.AdminRepo;
import com.Shopping.Repository.CurrentUserSessionRepo;
import com.Shopping.Repository.OrderRepo;

@Service
public class MySalesServiceImpl implements MySalesServices{

	@Autowired
	private AdminRepo arepo;
	
	@Autowired
	private CurrentUserSessionRepo cusRepo;
	
	@Autowired
	private OrderRepo orepo;
	
	@Override
	public List<Order> SalesForToday(Integer AdminId,String key) throws AdminException, LoginException, OrderException  {
		
		 checkLogin(key, AdminId);
		
		List<Order> olist = orepo.findByOrderDate(LocalDate.now());
		
		if(olist.size()==0) throw new OrderException("No Order placed Today");
		
		return olist;
	}

	@Override
	public List<Order> SalesForWeek(Integer AdminId,String key) throws AdminException, LoginException, OrderException {
		 checkLogin(key, AdminId);
			
			List<Order> olist =orepo.findByOrderDateBetween(LocalDate.now().minusWeeks(1), LocalDate.now());
			
			if(olist.size()==0) throw new OrderException("No Order placed in last Week");
			
		return olist;
	}

	@Override
	public List<Order> SalesForMonth(Integer AdminId,String key) throws AdminException, LoginException, OrderException {
		 checkLogin(key, AdminId);
			
			List<Order> olist =orepo.findByOrderDateBetween(LocalDate.now().minusMonths(1), LocalDate.now());
			
			if(olist.size()==0) throw new OrderException("No Order placed in last Week");
			
		return olist;
	}

	@Override
	public List<Order> SalesForYear(Integer AdminId,String key) throws AdminException, LoginException, OrderException {
		 checkLogin(key, AdminId);
			
			List<Order> olist =orepo.findByOrderDateBetween(LocalDate.now().minusYears(1), LocalDate.now());
			
			if(olist.size()==0) throw new OrderException("No Order placed in last Year");
			
		return olist;
	}

	@Override
	public List<Order> SalesBetweenDates(LocalDate l1, LocalDate l2, Integer AdminId, String key)
			throws AdminException, LoginException, OrderException {
		 checkLogin(key, AdminId);
			
			List<Order> olist =orepo.findByOrderDateBetween(l1, l2);
			
			if(olist.size()==0) throw new OrderException("No Order placed between "+l1+" and "+l2);
			
		return olist;
	}

	public Admin checkLogin(String key, Integer AdminId) throws LoginException, AdminException {
		Optional<Admin> opt = arepo.findById(AdminId);
		if (opt.isEmpty())
			throw new AdminException("No Admin Found with id:- " + AdminId);

		Admin admin = opt.get();
		CurrentUserSession cus = cusRepo.findByUuid(key);

		if (cus == null)
			throw new LoginException("Invalid Current Key");
		if (cus.getUserId() != admin.getAdminId())
			throw new LoginException("Please Login first.....");

		return admin;

	}
	
	
}
