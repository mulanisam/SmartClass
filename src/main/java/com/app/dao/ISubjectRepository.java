package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Subject;

public interface ISubjectRepository extends JpaRepository<Subject, Integer> {

}
