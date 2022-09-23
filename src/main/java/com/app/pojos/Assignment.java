package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "assignments")
public class Assignment extends BaseEntity {
	//@NotBlank(message = "assignmentNo is required")
	@Column(name = "assignment_no")
	private int assignmentNo;
	
	@Column(name = "assignment_name")
	private String assignmentName;

	@Column(name = "file_type")
	private  String getFileType;
	
	//@NotBlank(message = "date is required")
	@Column(name = "publish_date")
	private LocalDate publishDate;
	
	@JsonIgnoreProperties("subId")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sub_id",nullable = false)
	private Subject subId;
	
	@JsonIgnoreProperties("stdId")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "std_id",nullable = false)
	private Std stdId;
	
	@Lob
	@Column(name = "assign_file")
	private byte[] assignmentFile;

	
	}
	 
	
	

