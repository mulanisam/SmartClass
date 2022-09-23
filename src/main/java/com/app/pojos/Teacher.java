package com.app.pojos;



import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "teachers")
public class Teacher extends BaseEntity {
	
	@NotBlank(message = "First Name is required")
	@Column(name = "first_name", length = 20, nullable = false)
	private String firstName;
	
	@NotBlank(message = "Last Name is required")
	@Column(name = "last_name", length = 20, nullable = false)
	private String lastName;
	
	@NotBlank(message = "Gender is required")
	private String gender;
	
	@NotBlank(message = "Email is required")
	@Column(length = 50, nullable = false, unique = true)
	private String email;
	
	@NotBlank(message = "Password is required")
	@Column( length = 20, nullable = false)
	private String password;
	
	
	@NotBlank(message = "Role is required")
	@Column( length = 20, nullable = false)
	private String role;
	//bi dir relationship between Teacher 1<----* Subject
	@JsonIgnoreProperties("subjects")
	@ManyToOne
	//@NotBlank(message = "subject is required")
	private Subject subjects;
	
	private boolean status ;
}
