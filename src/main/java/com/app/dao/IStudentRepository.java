package com.app.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.Period;
import com.app.pojos.Student;

public interface IStudentRepository extends JpaRepository<Student, Integer> {
	
	Optional<Student> findByEmailAndPasswordAndRole(String email,String password,String role );
	
	@Query("select s from Student s where s.standards.id =?1")
	List<Student> findStudentsByStdId(int stdId);

	@Query("select s.firstName,s.lastName,s.standards.id from Student s where s.status = false")
	List<String> getStudentRegRequest();
}
