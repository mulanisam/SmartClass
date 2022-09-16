package com.app.service;

import java.time.LocalDate;
import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.StudentRegisterRequest;
import com.app.dto.UserLoginResponse;

public interface IStudentService {
	UserLoginResponse login(String email, String password, String role);
	ApiResponse registerNewStudent(StudentRegisterRequest student);
	List<String> getPeriodsDetailsByStdAndDate(int std_id, LocalDate date);
	List<String> getWeeklyScheduleDetailsByStd(int stdId);
	List<String> getAssignment(int stdId,int subId);
}
