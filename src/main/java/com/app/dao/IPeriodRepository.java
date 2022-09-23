package com.app.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.Period;

public interface IPeriodRepository extends JpaRepository<Period, Integer> {
	
	@Query("select p.subjectId.subjectName, p.startTime, p.endTime, p.teacherId.firstName, p.teacherId.lastName"
			+ " from Period p where p.std.id =?1 and p.date = CURRENT_DATE")
	 List<String> findByStdAndDate(int stdId);

	@Query("select DATE_FORMAT(p.date , '%Y-%m-%d'), p.startTime, p.endTime,p.subjectId.subjectName, "
			+ "p.teacherId.firstName, p.teacherId.lastName"
			+ " from Period p where p.std.id =?1 and Week(p.date) = Week(now()) order by p.date , p.startTime")
	List<String> getWeeklyScheduleByStd(int stdId);
	
	@Query("select p.std.std, p.startTime, p.endTime, p.subjectId.subjectName from Period p where "
			+ "p.teacherId.id = ?1 and p.date = CURRENT_DATE")
	List<String> findByTeacherIdAndDate(int teacherId);
	
	@Query("select DATE_FORMAT(p.date , '%Y-%m-%d'), p.startTime, p.endTime, p.std.std, p.subjectId.subjectName "
			+ "from Period p where p.teacherId.id = ?1 and  Week(p.date) = Week(now()) "
			+ "order by p.date , p.startTime ")
	List<String> getWeeklyScheduleByTeacherId(int teacherId);
}
