package com.app.pojos;

import java.sql.Time;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

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
@Table(name = "periods")
public class Period extends BaseEntity{
	
	@JsonIgnoreProperties("std")
	@OneToOne
	@NotBlank(message = "std is required")
	@JoinColumn(name = "std_id",nullable = false)
	private Std std;
	
	@NotBlank(message = "Date is required")
	private LocalDate date;
	
	@Column(name = "start_time")
	@NotBlank(message = "Start time required")
	private Time startTime;
	
	@Column(name = "end_time")
	@NotBlank(message = "Start time required")
	private Time endTime;
	
	@JsonIgnoreProperties("subjectId")
	@OneToOne
	@NotBlank(message = "Subject is required")
	@JoinColumn(name = "subject_id",nullable = false)
	private Subject subjectId;
	
	@JsonIgnoreProperties("teacherId")
	@ManyToOne
	//@NotBlank(message = "Teacher is required")
	@JoinColumn(name = "teacher_id",nullable = false)
	private Teacher teacherId;
	
}
