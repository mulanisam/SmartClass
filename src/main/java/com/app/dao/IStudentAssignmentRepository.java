package com.app.dao;

import java.util.OptionalInt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.StudentAssignment;

public interface IStudentAssignmentRepository extends JpaRepository<StudentAssignment, Integer> {

	@Query("select sa from StudentAssignment sa where sa.student.id = ?1 and sa.assignment.id = ?2")
	StudentAssignment findByStudIdAndAssignmentId(int studentId, int assignmentId);


}
