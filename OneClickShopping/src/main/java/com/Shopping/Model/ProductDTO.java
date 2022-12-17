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
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productDtoId;
	
	private Integer seller_ProductId;
	private String ProductDtoName;
	private Integer price;
	private String Category;
	private Integer Quantity;
	
//	@ManyToOne
//	@JsonIgnore
//	private Order order;
	
}
