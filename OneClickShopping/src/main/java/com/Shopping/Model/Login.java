package com.Shopping.Model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Login {

	@Size(min = 3, max = 20, message = "UserName Should be of 3 to 20 Characters.")
	private String Email;
	
	@NotEmpty(message = "Password Should not be Empty")
	@NotBlank(message=  "password Should not be Blank")
	@NotNull(message = "Password Should Not be Null")
	private String password;
}
