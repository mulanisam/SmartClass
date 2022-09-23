package com.app.controller;

import javax.validation.Valid;

import com.app.dto.UserLoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.IAdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000/")
public class AdminContoller {
	
	@Autowired
	private IAdminService adminService;
	
	@PostMapping("/login")
	ResponseEntity<?> authenticateAdmin(@RequestBody @Valid UserLoginRequest admin){
		return ResponseEntity.ok(adminService.login(admin.getEmail(), admin.getPassword(), admin.getRole()));
	}
	
	@GetMapping("/registerrequest")
	ResponseEntity<?> fetchAllRegistrationRequest(@RequestParam String role){
		return ResponseEntity.ok(adminService.getAllRequest(role));
		
	}
}
