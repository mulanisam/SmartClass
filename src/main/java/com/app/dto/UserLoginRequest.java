package com.app.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserLoginRequest {
	
	@NotBlank(message = "Email is required")
	private String email;
	@NotBlank(message = "Email is required")
	private String password;
	@NotBlank(message = "Role is required")
	private String role;
}
