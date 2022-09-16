package com.app.dao;

import java.util.List;

import com.app.pojos.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface IAssignmentRepository extends JpaRepository<Assignment, Integer>{
	@Query("select a.subId.subjectName, a.assignmentNo, DATE_FORMAT(a.publishDate , '%Y-%m-%d'), a.assignmentFile from  Assignment a "
			+ "where a.stdId.id =?1 and a.subId.id =?2 order by  a.subId, a.assignmentNo ")
	List<String> getAssignmentBySubIdAndStdId(int stdId, int subId);
	
	@Query("select max(a.assignmentNo) from Assignment a where a.stdId.id = ?1 and a.subId.id = ?2")
	int findByStdIdAndSubId(int stdId, int subId);

}
//, a.assignmentFile 
