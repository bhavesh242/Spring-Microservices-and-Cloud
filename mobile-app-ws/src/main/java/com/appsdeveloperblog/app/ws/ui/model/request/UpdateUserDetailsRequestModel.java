package com.appsdeveloperblog.app.ws.ui.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateUserDetailsRequestModel {
	@NotNull(message = "firstName cannot be Null")
	@Size(min = 2, message = "First Name should be atleast 2 characters long")
	private String firstName;
	@NotNull(message = "lastName cannot be Null")
	@Size(min = 2, message = "Last Name should be atleast 2 characters long")
	private String lastName;

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
}
