package com.app.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.ApiResponse;
import com.app.dto.AssignmentRequestDto;
import com.app.dto.TeacherRegisterRequest;
import com.app.dto.TimeTableRequestByTeacher;
import com.app.dto.UserLoginRequest;
import com.app.service.IFileHandlingService;
import com.app.service.ITeacherService;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
	@Autowired
	private ITeacherService teacherService;
	
	@Autowired
	private IFileHandlingService fileservice;
	
	@PostMapping("/login")
	public ResponseEntity<?> authenticateTeacher(@RequestBody @Valid UserLoginRequest user){
		return ResponseEntity.ok(teacherService.login(user.getEmail(), user.getPassword(), user.getRole()));
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> registerTeacher(@RequestBody @Valid TeacherRegisterRequest teacher){
		return ResponseEntity.ok(teacherService.registerNewTeacher(teacher));
	}
	
	@PostMapping("/timetable")
	public ResponseEntity<?> getTimeTableByTeacherIdAndDate(@RequestBody @Valid TimeTableRequestByTeacher teacher){
		return ResponseEntity.ok(teacherService.getTimeTable(teacher.getTeacherId(),teacher.getDate()));
	}
	@PostMapping("/{teacherId}")
	public ResponseEntity<?> getWeeklyScheduleByStd( @PathVariable int teacherId){
		return ResponseEntity.ok(teacherService.getWeeklyScheduleDetailsByTeacherId(teacherId));
		
	}
	
	@PostMapping("/createassignment") 
	public ResponseEntity<?> createAssignment(@RequestParam("assignmentFile") MultipartFile assignment,@RequestParam("stdId") int stdId,@RequestParam("subId") int subId ) throws IOException{ 
		System.out.println(assignment.getOriginalFilename()+ stdId + subId);
		AssignmentRequestDto dto = new AssignmentRequestDto();
		dto.setAssignmentFile(assignment);
		dto.setDate(LocalDate.now());
		dto.setStd(stdId);
		dto.setSubject(subId);
	//	ApiResponse res = fileservice.createAssignment(dto);
	//	System.out.println(res.getMessage());
		return ResponseEntity.ok(fileservice.createAssignment(dto));
	  
	  }
	 
	 
	 
}
