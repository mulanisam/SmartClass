package com.app.service;

import java.time.LocalDate;
import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.AssignmentRequestDto;
import com.app.dto.TeacherRegisterRequest;
import com.app.dto.UserLoginResponse;


public interface ITeacherService {
	UserLoginResponse login(String email, String password, String role);
	ApiResponse registerNewTeacher(TeacherRegisterRequest teacher);
	List<String> getTimeTable(int teacherId, LocalDate date);
	List<String> getWeeklyScheduleDetailsByTeacherId(int teacherId);
	//Assignment setAssignment(String std, String subject,int assignmentNo);
	
}
