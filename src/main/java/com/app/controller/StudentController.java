package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.StudentRegisterRequest;
import com.app.dto.SubAssignmentRequest;
import com.app.dto.TimeTableRequestByStudent;
import com.app.dto.UserLoginRequest;
import com.app.service.IFileHandlingService;
import com.app.service.IStudentService;

@RestController
@RequestMapping("/student")

public class StudentController {
	
	@Autowired
	private IStudentService studentService;
	
	@Autowired
	private IFileHandlingService fileService;
	
	@PostMapping("/login")
	public ResponseEntity<?> authenticateStudent(@RequestBody @Valid UserLoginRequest user){
		
		return  ResponseEntity.ok(studentService.login(user.getEmail(), user.getPassword(), user.getRole()));
		// return new ResponseEntity<>(studentService.login(user.getEmail(), user.getPassword(), user.getRole()),HttpStatus.OK);
		
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> registerStudent(@RequestBody @Valid StudentRegisterRequest student ){
		return ResponseEntity.ok(studentService.registerNewStudent(student));
		
	}
	
	@PostMapping("/timetable")
	public ResponseEntity<?> getPeriodsByStdAndDate(@RequestBody @Valid TimeTableRequestByStudent timetable){
		return ResponseEntity.ok(studentService.getPeriodsDetailsByStdAndDate(timetable.getStd_id(),timetable.getDate()));
		
	}
	@PostMapping("/{stdId}")
	public ResponseEntity<?> getWeeklyScheduleByStd( @PathVariable int stdId){
		return ResponseEntity.ok(studentService.getWeeklyScheduleDetailsByStd(stdId));
		
	}
	@PostMapping("/subassignment")
	public ResponseEntity<?> getAssignmentByStdAndSub(@RequestBody @Valid SubAssignmentRequest subAssignment ){
		return ResponseEntity.ok(studentService.getAssignment(subAssignment.getStdId(),subAssignment.getSubId()));
		
	}
	
	@PostMapping("/sdownload/{assignmentId}")
	public ResponseEntity<?> studDownloadAssignment(@PathVariable int assignmentId){
		return ResponseEntity.ok(fileService.studAssignment(assignmentId));
	}
	
	
}
