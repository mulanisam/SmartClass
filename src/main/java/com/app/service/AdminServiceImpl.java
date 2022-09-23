package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import com.app.customExceptionHandler.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.app.dao.IStudentRepository;
import com.app.dao.ITeacherRepository;
import com.app.dto.AdminLoginResponse;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private IStudentRepository studentRepo;
	
	@Autowired
	private ITeacherRepository teacherRepo;
	
	@Override
	public AdminLoginResponse login(String email, String password, String role) {
		if(email.equals("shilpi@gmail.com") && password.equals("shilpi@123") && role.equals("admin"))
			return new AdminLoginResponse("Shilpi","Shalini","shilpi@gmail.com","admin");
		else
			throw new ResourceNotFoundException("Credentials Invalid!");
		
	}

	@Override
	public List<String> getAllRequest(String role) {
		if(role.equals("student")) {
			return studentRepo.getStudentRegRequest();
		}else
			return teacherRepo.getTeacherRegRequest();
	}

}
