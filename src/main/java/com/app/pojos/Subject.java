package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "subjects")
public class Subject extends BaseEntity {
	
	@Column(name = "sub_name", length = 20, nullable = false)
	@NotBlank(message = "Subject Name is required")
	private String subjectName;
	
	//bi dir relationship between Teacher 1<----* Subject
//	@JsonIgnoreProperties("teachers")
//	@ManyToOne
//	@JoinColumn(name = "teacher_id",nullable = false)
//	private Teacher teachers;
	
}
