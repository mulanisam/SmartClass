package com.app.service;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.web.multipart.MultipartFile;

import com.app.dto.ApiResponse;
import com.app.dto.AssignmentRequestDto;


public interface IFileHandlingService {

	ApiResponse createAssignment(@Valid AssignmentRequestDto assignment);

	AssignmentRequestDto studAssignment(int assignmentId);

	ApiResponse studSubmitAssignment(int studentId, int assignmentId,MultipartFile assignment) throws IOException;

	byte[] teacherDownload(int studentId, int assignmentId);
}
