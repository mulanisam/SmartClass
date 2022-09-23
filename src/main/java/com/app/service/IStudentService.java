package com.app.service;

import java.time.LocalDate;
import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.StudentRegisterRequest;
import com.app.dto.StudentLoginResponse;

public interface IStudentService {
	StudentLoginResponse login(String email, String password, String role);
	ApiResponse registerNewStudent(StudentRegisterRequest student);
	List<String> getPeriodsDetailsByStdAndDate(int stdId);
	List<String> getWeeklyScheduleDetailsByStd(int stdId);
	List<String> getAssignment(int stdId,int subId,int studentId);
}
