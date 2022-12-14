package com.gabby.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Login {

	
	
	@NotNull(message = "Email Id can't be null..")
	@NotBlank(message = "Email Id Cannot be blank.")
	@NotEmpty(message = "Email id cannot be null")
	private String email;
	
	
	@NotNull(message = "Password cannot be null")
	@NotBlank(message = "Password cannot be blank")
	@NotEmpty(message = "Password cannot be empty")
	private String password;
	
	
	@NotNull(message = "Role cannot be null")
	@NotBlank(message = "Role cannot be blank")
	@NotEmpty(message = "Role cannot be empty")
	private String roll;
	
}
