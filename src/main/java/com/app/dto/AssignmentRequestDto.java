package com.app.dto;

import java.io.IOException;
import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
//@Setter
@ToString
public class AssignmentRequestDto {
	
	public void setStd(int std) {
		this.stdId = std;
	}


	public void setSubject(int subject) {
		this.subId = subject;
	}


	public void setDate(LocalDate date) {
		this.publishDate = date;
	}


	public void setAssignmentFile(MultipartFile assignmentFile) throws IOException {
		this.assignmentFile = assignmentFile.getBytes();
	}


	private int stdId;
	private int subId;
	private LocalDate publishDate;
	
	
	@JsonProperty(access = Access.READ_WRITE)
	private byte[] assignmentFile;
}
