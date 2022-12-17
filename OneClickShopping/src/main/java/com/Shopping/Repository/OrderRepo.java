package com.Shopping.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Shopping.Model.Address;
import com.Shopping.Model.Customer;
import com.Shopping.Model.Order;
import com.Shopping.Model.Payment;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer>{

	public List<Order> findByCustomer(Customer customer);

	public List<Order> findByOrderDate(LocalDate orderDate);

	public List<Order> findByOrderDateBetween(LocalDate s_orderDate, LocalDate e_orderDate);

	public List<Order> findByOrderDateGreaterThanEqual(LocalDate orderDate);
}
