package com.gabby.model;

import javax.annotation.Generated;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;
	
	
	@Size(min =3, max = 25, message = "Product name should contain min 3 charater")
	private String productName;
	
	@Min(value = 1, message = "Please Enter the valid  price")
	private Double price;
	
	
	private String color;
	
	
	private String dimension;
	
	
	private String manufacture;
	
	
	@Min(value = 1, message = "Please Enter the valid Quantity")
	private Integer quantity;
	
	@Embedded
	private Category category;

	public Product(@Size(min = 3, max = 25, message = "Product name should contain min 3 charater") String productName,
			@Min(value = 1, message = "Please Enter the valid  price") Double price, String color, String dimension,
			String manufacture, @Min(value = 1, message = "Please Enter the valid Quantity") Integer quantity,
			Category category) {
		super();
		this.productName = productName;
		this.price = price;
		this.color = color;
		this.dimension = dimension;
		this.manufacture = manufacture;
		this.quantity = quantity;
		this.category = category;
	}
	
	
	
	
	
	
	
}
