package com.app.service;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.app.customExceptionHandler.ResourceNotFoundException;
import com.app.pojos.Student;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.app.dao.IAssignmentRepository;
import com.app.dao.IPeriodRepository;
import com.app.dao.IStudentRepository;
import com.app.dto.ApiResponse;
import com.app.dto.StudentRegisterRequest;
import com.app.dto.UserLoginResponse;


import lombok.extern.slf4j.Slf4j;

@Service
@Transactional

public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	private IStudentRepository studentRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private IAssignmentRepository assignmentRepo;
	
	@Autowired 
	private IPeriodRepository periodRepo;
	 	
	@Override
	public UserLoginResponse login(String email, String password, String role) {
		Student student = studentRepo.findByEmailAndPasswordAndRole(email, password, role).orElseThrow(() -> new ResourceNotFoundException("Credentials Invalid!"));
		
		return new UserLoginResponse(student.getFirstName(),student.getLastName(),student.getEmail(),student.getRole());
	}

	@Override
	public ApiResponse registerNewStudent(StudentRegisterRequest studentDto) {
		Student transientStudent = mapper.map(studentDto, Student.class);
		Student persistentStudent =  studentRepo.save(transientStudent);
		
		return new ApiResponse("Student Register Successfully with ID:"+persistentStudent.getId());
	}

	@Override
	public List<String> getPeriodsDetailsByStdAndDate(int stdId, LocalDate date) {
		
		return periodRepo.findByStdAndDate(stdId, date);
	}

	@Override
	public List<String> getWeeklyScheduleDetailsByStd(int stdId) {
		
		return periodRepo.getWeeklyScheduleByStd(stdId);
	}

	@Override
	public List<String> getAssignment(int stdId, int subId) {
	
		return assignmentRepo.getAssignmentBySubIdAndStdId(stdId,subId);
	}

}
