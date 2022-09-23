package com.app.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class TeacherRegisterRequest {
	@NotBlank(message = "First Name is required")
	@Size(min = 3, max = 10)
	private String firstName;
	
	@NotBlank(message = "Last Name is required")
	@Size(min = 3, max = 10)
	private String lastName;
	
	@NotBlank(message = "Gender is required")
	private String gender;
	
	@Email
	@NotBlank(message = "Email is required")
	private String email;
	
	@Size(min = 5, max = 20)
	@NotBlank(message = "Password is required")
	private String password;
	
	
	private String role = "teacher";
	
	//@NotBlank(message = "Subject Name is required")
	private int subject;
	
}
