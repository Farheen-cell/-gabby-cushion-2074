package com.Shopping.Services;

import java.time.LocalDate;
import java.util.List;

import com.Shopping.Exceptions.AdminException;
import com.Shopping.Exceptions.LoginException;
import com.Shopping.Exceptions.OrderException;
import com.Shopping.Model.Order;

public interface MySalesServices {

	public List<Order> SalesForToday(Integer AdminId,String key) throws AdminException,LoginException,OrderException;
	public List<Order> SalesForWeek(Integer AdminId,String key) throws AdminException,LoginException,OrderException;
	public List<Order> SalesForMonth(Integer AdminId,String key) throws AdminException,LoginException,OrderException;
	public List<Order> SalesForYear(Integer AdminId,String key) throws AdminException,LoginException,OrderException;
	public List<Order> SalesBetweenDates(LocalDate l1,LocalDate l2,Integer AdminId,String key)
			throws AdminException,LoginException,OrderException;
}
