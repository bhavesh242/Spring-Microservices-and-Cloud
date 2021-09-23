package com.appsdeveloperblog.app.ws.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailsRequestModel {
	@NotNull(message = "firstName cannot be Null")
	@Size(min = 2, message = "First Name should be atleast 2 characters long")
	private String firstName;
	@NotNull(message = "lastName cannot be Null")
	@Size(min = 2, message = "First Name should be atleast 2 characters long")
	private String lastName;
	@NotNull(message = "email cannot be Null")
	@Email(message = "Enter Valid email")
	private String email;
	@NotNull(message = "password cannot be Null")
	@Size(min = 8, max = 16, message = "Password must be greater than or equal to 8 and less than 16 characters")
	private String password;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}