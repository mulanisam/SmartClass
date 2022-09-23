package com.app.service;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import javax.transaction.Transactional;

import com.app.customExceptionHandler.ResourceNotFoundException;
import com.app.pojos.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.app.dao.IAssignmentRepository;
import com.app.dao.IStudentAssignmentRepository;
import com.app.dao.IStudentRepository;
import com.app.dto.ApiResponse;
import com.app.dto.AssignmentRequestDto;

@Service
@Transactional
public class FileHandlingServiceImpl implements IFileHandlingService {

	@Autowired
	private IAssignmentRepository assignmentRepo;
	
	@Autowired
	private IStudentRepository studentRepo;
	
	@Autowired
	private IStudentAssignmentRepository studentAssignmentRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public ApiResponse createAssignment( AssignmentRequestDto assignment) {
		Subject subId = new Subject();
		subId.setId(assignment.getSubId());
		Std stdId = new Std();
		stdId.setId(assignment.getStdId());
		int max =  assignmentRepo.findByStdIdAndSubId(assignment.getStdId(),assignment.getSubId()).orElse(0);
		//OptionalInt max = asg.stream().mapToInt(Assignment::getAssignmentNo).max();
		System.out.println(max);
		Assignment transientAssignment = new Assignment(max + 1,assignment.getAssignmentName(),assignment.getGetFileType() ,assignment.getPublishDate(),subId,stdId, assignment.getAssignmentFile());//mapper.map(assignment, Assignment.class);
		//System.out.println(transientAssignment.getStdId());
		Assignment persistentAssignment = assignmentRepo.save(transientAssignment);
		//System.out.println(persistentAssignment.getAssignmentName());
		List<Student> students = studentRepo.findStudentsByStdId(assignment.getStdId());
		for (Student student : students) {
			StudentAssignment transientStudAssign = new StudentAssignment(null, "Pending", student, persistentAssignment);
			studentAssignmentRepo.save(transientStudAssign);
		}
		
		//System.out.println(persistentAssignment.getPublishDate()+ " "+persistentAssignment.getId());
		return new ApiResponse("Assignment Upload Successfully with Assignment Id:"+persistentAssignment.getId());
		
//		File path = new File(imagePath);
//		if (path.isFile() && path.canRead()) {
//			// => valid path
//			user.setImage(FileUtils.readFileToByteArray(path));
	}

	@Override
	public AssignmentRequestDto studAssignment(int assignmentId) {
		Assignment assign = assignmentRepo.findById(assignmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid AssignmentId"));
		return new AssignmentRequestDto(assign.getStdId().getId(),assign.getSubId().getId(),assign.getPublishDate(),assign.getAssignmentName(),assign.getGetFileType(),assign.getAssignmentFile());
	}

	@Override
	public ApiResponse studSubmitAssignment(int studentId, int assignmentId, MultipartFile assignment) throws IOException {
		//System.out.println(assignment.getOriginalFilename() + assignment.getSize());
		StudentAssignment stud = studentAssignmentRepo.findByStudIdAndAssignmentId(studentId,assignmentId);
		stud.setSubmitFile(assignment.getBytes());
		//System.out.println(assignment.getOriginalFilename() +" "+ assignment.getSize());
		stud.setRemarks("Submitted");
		return new ApiResponse("Assignment for:"+stud.getAssignment().getSubId().getSubjectName()
				+" with Assignment NO:"+ stud.getAssignment().getAssignmentNo()
				+" with tracking Id:"+stud.getId()
				+ " Submitted Successsfully");
	}

	@Override
	public byte[] teacherDownload(int studentId, int assignmentId) {
		StudentAssignment assign = studentAssignmentRepo.findByStudIdAndAssignmentId(studentId,assignmentId);
				//.orElseThrow(() -> new ResourceNotFoundException("Invalid AssignmentId"));
		assign.setRemarks("Under Cheking");
		return assign.getSubmitFile();
	}

}
