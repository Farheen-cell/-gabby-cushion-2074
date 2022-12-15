package com.gabby.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class User {

	@Id
	private String id;
	private String password;

	// Choose From Admin or Customer
	private String role;
}
