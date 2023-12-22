package com.quiz.lesson04.mapper;

import org.springframework.stereotype.Repository;

import com.quiz.lesson04.domain.Realtor;

@Repository
public interface RealtorMapper {

	// input : Realtor / output : X
	public void insertRealtor(Realtor realtor);
	
	// input : id / output : Realtor
	public Realtor selectRealtorById(int id);
	
} // public interface RealtorMapper