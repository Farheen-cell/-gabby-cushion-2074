package com.Shopping.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int seller_ProductId;
	private String productName;
	private int price;
	private String color;
	private String dimention;
	private String manufactuer;
	private String category;
	
	@JsonIgnore
	@ManyToOne
	private Seller seller;
}
