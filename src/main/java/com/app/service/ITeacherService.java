package com.app.service;

import java.time.LocalDate;
import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.AssignmentRequestDto;
import com.app.dto.TeacherRegisterRequest;
import com.app.dto.StudentLoginResponse;
import com.app.dto.TeacherLoginResponse;


public interface ITeacherService {
	TeacherLoginResponse login(String email, String password, String role);
	ApiResponse registerNewTeacher(TeacherRegisterRequest teacher);
	List<String> getTimeTable(int teacherId);
	List<String> getWeeklyScheduleDetailsByTeacherId(int teacherId);
	//Assignment setAssignment(String std, String subject,int assignmentNo);
	
}
