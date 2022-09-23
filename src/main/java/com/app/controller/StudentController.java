package com.app.controller;

import java.io.IOException;

import javax.validation.Valid;

import com.app.dto.AssignmentRequestDto;
import com.app.dto.StudentRegisterRequest;
import com.app.dto.SubAssignmentRequest;
import com.app.dto.UserLoginRequest;
import com.app.service.IFileHandlingService;
import com.app.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "*")
public class StudentController {
	
	@Autowired
	private IStudentService studentService;
	
	@Autowired
	private IFileHandlingService fileService;
	
	@PostMapping("/login")
	public ResponseEntity<?> authenticateStudent(@RequestBody @Valid UserLoginRequest user){
		System.out.println(user.toString());
		return  ResponseEntity.ok(studentService.login(user.getEmail(), user.getPassword(), user.getRole()));
		// return new ResponseEntity<>(studentService.login(user.getEmail(), user.getPassword(), user.getRole()),HttpStatus.OK);
		
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> registerStudent(@RequestBody @Valid StudentRegisterRequest student ){
		return ResponseEntity.ok(studentService.registerNewStudent(student));
		
	}
	
	@GetMapping("/timetable/{stdId}")
	public ResponseEntity<?> getPeriodsByStdAndDate(@PathVariable int stdId){
		return ResponseEntity.ok(studentService.getPeriodsDetailsByStdAndDate(stdId));
		
	}
	@GetMapping("/{stdId}")
	public ResponseEntity<?> getWeeklyScheduleByStd( @PathVariable int stdId){
		return ResponseEntity.ok(studentService.getWeeklyScheduleDetailsByStd(stdId));
		
	}
	@PostMapping("/subassignment")
	public ResponseEntity<?> getAssignmentByStdAndSub(@RequestBody @Valid SubAssignmentRequest subAssignment ){
		return ResponseEntity.ok(studentService.getAssignment(subAssignment.getStdId(),subAssignment.getSubId(),subAssignment.getStudentId()));
		
	}
	
	@GetMapping(value = "/sdownload/{assignmentId}")
	public ResponseEntity<?> studDownloadAssignment(@PathVariable int assignmentId){
		AssignmentRequestDto downloadDto = fileService.studAssignment(assignmentId);
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(downloadDto.getGetFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + downloadDto.getAssignmentName() + "\"")
				.body(new ByteArrayResource(downloadDto.getAssignmentFile()));
	}
	
	@PostMapping(value = "/studSubmitAssignment/{studentId}/{assignmentId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> studUploadAssignment(@RequestParam("assignmentFile") MultipartFile assignment,@PathVariable int studentId,@PathVariable int assignmentId) throws IOException{
		return ResponseEntity.ok(fileService.studSubmitAssignment(studentId,assignmentId,assignment));
	}
	
}
