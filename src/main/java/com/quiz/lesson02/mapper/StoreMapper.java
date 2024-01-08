package com.quiz.lesson02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.quiz.lesson02.domain.Store;

@Mapper
public interface StoreMapper {

	// input : X -> BO에게 요청 받음
	// output : List<Store> -> BO에게 돌려 준다
	public List<Store> selectStoreList();
	
} // public interface StoreMapper