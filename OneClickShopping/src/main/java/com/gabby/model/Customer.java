package com.gabby.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerId;
    
	@Size(min = 3 , max = 15, message ="first Name Should be Minimum 3 and Maximum 15")
    private String firstname;
    
	
	@Size(min = 3 , max = 15, message ="Last Name Should be Minimum 3 and Maximum 15")
    private String lastname;
	@Size(min = 10 , max = 10, message ="Mobile Number Should Contains 10 digits")
    private String mobilenumber;
     
	@Email(message = "Please Provide the valid email")
    private String email;
    
	@Size(min = 6 , max = 20, message ="Password should be minumem 6 and maximum 16")
    private String password;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "cus_Address", joinColumns = @JoinColumn(name ="customer_id", referencedColumnName = "customerId"))
	private Address address;

	public Customer(
			@Size(min = 3, max = 15, message = "first Name Should be Minimum 3 and Maximum 15") String firstname,
			@Size(min = 3, max = 15, message = "Last Name Should be Minimum 3 and Maximum 15") String lastname,
			@Size(min = 10, max = 10, message = "Mobile Number Should Contains 10 digits") String mobilenumber,
			@Email(message = "Please Provide the valid email") String email,
			@Size(min = 6, max = 20, message = "Password should be minumem 6 and maximum 16") String password,
			Address address) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.mobilenumber = mobilenumber;
		this.email = email;
		this.password = password;
		this.address = address;
	}

	
	
	
}
