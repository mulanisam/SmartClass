package com.app.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.app.customExceptionHandler.ResourceNotFoundException;
import com.app.pojos.Subject;
import com.app.pojos.Teacher;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.app.dao.IPeriodRepository;
import com.app.dao.ISubjectRepository;
import com.app.dao.ITeacherRepository;
import com.app.dto.ApiResponse;
import com.app.dto.TeacherRegisterRequest;
import com.app.dto.StudentLoginResponse;
import com.app.dto.TeacherLoginResponse;

@Service
@Transactional
public class TeacherServiceImpl implements ITeacherService {
	
	@Autowired
	private ITeacherRepository teacherRepo;
	
	@Autowired
	private ModelMapper mapper; 
	
	@Autowired
	private IPeriodRepository periodRepo;
	
	@Autowired
	private ISubjectRepository subRepo;
	
	@Override
	public TeacherLoginResponse login(String email, String password, String role) {
		Teacher teacher = teacherRepo.findByEmailAndPasswordAndRole(email, password, role).orElseThrow(() -> new ResourceNotFoundException("Credentials Invalid!"));
		
		return new TeacherLoginResponse(teacher.getFirstName(),teacher.getLastName(),teacher.getEmail(),teacher.getRole(),teacher.getId());
	}


	@Override
	public ApiResponse registerNewTeacher(TeacherRegisterRequest teacher) {
		Subject subject = subRepo.findById(teacher.getSubject()).orElseThrow(()-> new ResourceNotFoundException("Invalid SubjectID"));
//		List<Subject>subjects = new ArrayList<Subject>();
//		subjects.add(subId);
		Teacher transientTeacher = new Teacher(teacher.getFirstName(), teacher.getLastName(), teacher.getGender(), teacher.getEmail(), teacher.getPassword(), teacher.getRole(), subject,false);
		Teacher persistentTeacher = teacherRepo.save(transientTeacher);
		return new ApiResponse("Teacher register suceesfully with ID:"+persistentTeacher.getId());
	}


	@Override
	public List<String> getTimeTable(int teacherId) {
		
		return periodRepo.findByTeacherIdAndDate(teacherId);
	}


	@Override
	public List<String> getWeeklyScheduleDetailsByTeacherId(int teacherId) {
		
		return periodRepo.getWeeklyScheduleByTeacherId(teacherId);
	}

}
