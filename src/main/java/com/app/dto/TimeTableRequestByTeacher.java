package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TimeTableRequestByTeacher {
	
	//@NotBlank(message = "std_id is required")
	private int teacherId;
	//@NotBlank(message = "date is required")
	private LocalDate date;
}
