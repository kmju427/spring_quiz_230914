package com.quiz.lesson04.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.quiz.lesson04.domain.Realtor;

@Mapper
public interface RealtorMapper {

	// input : Realtor / output : X
	public void insertRealtor(Realtor realtor);
	
	// input : id / output : Realtor
	public Realtor selectRealtorById(int id);
	
} // public interface RealtorMapper