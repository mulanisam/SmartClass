package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Std;

public interface IStdRepository extends JpaRepository<Std, Integer> {

}
