package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "standards")
public class Std extends BaseEntity {
	
	@Column(unique = true)
	@NotBlank(message = "Std is required")
	private String std;
	
	@OneToOne
	@JoinColumn(name = "class_teacher_id",nullable = false)
	private Teacher classTeacher;
	
	//bi dir relationship between Std 1<----* Student
	@OneToMany(mappedBy = "standards",cascade = CascadeType.ALL)
	private List<Student> students = new ArrayList<>();
	
	
}
