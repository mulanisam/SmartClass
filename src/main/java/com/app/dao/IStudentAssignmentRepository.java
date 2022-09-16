package com.app.dao;

import com.app.pojos.StudentAssignment;
import org.springframework.data.jpa.repository.JpaRepository;



public interface IStudentAssignmentRepository extends JpaRepository<StudentAssignment, Integer> {

}
