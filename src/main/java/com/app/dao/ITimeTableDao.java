package com.app.dao;

import com.app.dto.TimeTableEnt;
import com.app.pojos.Period;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ITimeTableDao extends JpaRepository<Period,Integer> {

    @Query("select p from Period p join fetch p.teacher t join fetch p.subject s join fetch p.std c where c.std=:std and p.date=:date")
    List<Period> getTimeTable(@Param("std") String std, @Param("date") LocalDate date);

    //select c from MetroCard c join fetch c.user u where u.id=:id"
    //select p from Period p join fetch p.teacher t join fetch p.subject s join fetch p.ClassStandard c where c.std=:std and p.date=:date
}
