package com.app.service;

import javax.validation.Valid;

import com.app.dto.ApiResponse;
import com.app.dto.AssignmentRequestDto;

public interface IFileHandlingService {

	ApiResponse createAssignment(@Valid AssignmentRequestDto assignment);

	byte[] studAssignment(int assignmentId);
}
