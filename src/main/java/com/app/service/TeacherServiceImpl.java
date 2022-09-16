package com.app.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import com.app.customExceptionHandler.ResourceNotFoundException;
import com.app.pojos.Teacher;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.app.dao.IPeriodRepository;
import com.app.dao.ITeacherRepository;
import com.app.dto.ApiResponse;
import com.app.dto.TeacherRegisterRequest;
import com.app.dto.UserLoginResponse;


@Service
@Transactional
public class TeacherServiceImpl implements ITeacherService {
	
	@Autowired
	private ITeacherRepository teacherRepo;
	
	@Autowired
	private ModelMapper mapper; 
	
	@Autowired
	private IPeriodRepository periodRepo;
	
	@Override
	public UserLoginResponse login(String email, String password, String role) {
		Teacher teacher = teacherRepo.findByEmailAndPasswordAndRole(email, password, role).orElseThrow(() -> new ResourceNotFoundException("Credentials Invalid!"));
		
		return new UserLoginResponse(teacher.getFirstName(),teacher.getLastName(),teacher.getEmail(),teacher.getRole());
	}


	@Override
	public ApiResponse registerNewTeacher(TeacherRegisterRequest teacher) {
		Teacher transientTeacher = mapper.map(teacher, Teacher.class);
		Teacher persistentTeacher = teacherRepo.save(transientTeacher);
		return new ApiResponse("Teacher register suceesfully with ID:"+persistentTeacher.getId());
	}


	@Override
	public List<String> getTimeTable(int teacherId, LocalDate date) {
		
		return periodRepo.findByTeacherIdAndDate(teacherId,date);
	}


	@Override
	public List<String> getWeeklyScheduleDetailsByTeacherId(int teacherId) {
		
		return periodRepo.getWeeklyScheduleByTeacherId(teacherId);
	}

}
