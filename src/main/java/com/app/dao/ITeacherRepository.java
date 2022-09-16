package com.app.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.app.pojos.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ITeacherRepository extends JpaRepository<Teacher, Integer> {
	
	Optional<Teacher> findByEmailAndPasswordAndRole(String email,String password,String role );
	
//	@Query("Insert into Assignment (std,subId,assignmentNo) values (?1,?2,?3)")
//	Assignment setAssignmentForStudent(String std, String subject,int assinmentNo);

}
