package com.app.dto;

import java.io.IOException;
import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
//@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentRequestDto {

	private int stdId;
	private int subId;
	private LocalDate publishDate;
	private String assignmentName;
	private  String getFileType;

	@JsonProperty(access = Access.READ_WRITE)
	private byte[] assignmentFile;



	public void setStd(int std) {
		this.stdId = std;
	}

	public String getGetFileType() {
		return getFileType;
	}

	public void setGetFileType(MultipartFile assignmentFile) {
		this.getFileType = assignmentFile.getContentType();
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


	public void setAssignmentName(String assignmentName) {
		this.assignmentName = assignmentName;
	}



}
