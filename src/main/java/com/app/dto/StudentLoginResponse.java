package com.app.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StudentLoginResponse {
	private String firstName;
	private String lastName;
	private String email;
	private String role;
	private String distinct;
	private int distinctId;
	private int studentId;
	private boolean status;
}
