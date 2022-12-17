package com.Shopping.Model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartId;
	
	@OneToOne
	@JsonIgnore
	private Customer customer;
	
	private double cartValue;
	
	@ElementCollection
	@CollectionTable(name = "cart_product", joinColumns = @JoinColumn(name="cart_id"))
	@Column(name = "Quantity")
	@MapKeyJoinColumn(name = "product_id", referencedColumnName = "seller_ProductId")
	@JsonIgnore
	private Map<Products, Integer> products;
}
