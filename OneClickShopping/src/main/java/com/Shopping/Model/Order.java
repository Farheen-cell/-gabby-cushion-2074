package com.Shopping.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Order_table")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;
	
	private LocalDate orderDate;
	
	private String orderStatus;
	
	private double orderAmount;
	
	@JsonIgnore
	@ManyToOne
	private Customer customer;
	
//	@ElementCollection(fetch = FetchType.EAGER)
//	@CollectionTable(name="Order_table_Product",joinColumns = @JoinColumn(name="Order_table_Id"))
//	@Column(name="Quantity")
//	@MapKeyJoinColumn(name="Product_Id",referencedColumnName = "seller_ProductId")
//	@JsonIgnore
//	private Map<Products, Integer> products;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	private List<ProductDTO> productList;
	
	@OneToOne
	@JsonIgnore
	private Address address;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Payment payment;
	
}
