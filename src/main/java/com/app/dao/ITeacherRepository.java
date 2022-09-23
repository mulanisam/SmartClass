package com.app.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.Assignment;
import com.app.pojos.Teacher;

public interface ITeacherRepository extends JpaRepository<Teacher, Integer> {
	
	Optional<Teacher> findByEmailAndPasswordAndRole(String email,String password,String role );
	
	@Query("select t.firstName,t.lastName,t.subjects.id from Teacher t where t.status = false")
	List<String> getTeacherRegRequest();
	
//	@Query("Insert into Assignment (std,subId,assignmentNo) values (?1,?2,?3)")
//	Assignment setAssignmentForStudent(String std, String subject,int assinmentNo);

}
