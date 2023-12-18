package com.quiz.lesson03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson03.domain.RealEstate;

@Repository
public interface RealEstateMapper {

	// QUIZ01 - 1
	// input : id
	// output : estate
	public RealEstate selectRealEstateById(int id);
	
	// QUIZ01 - 2
	// input : rentPrice
	// output : List<Estate>
	public List<RealEstate> selectRealEstateListByRentPrice(int rentPrice);
	
	// QUIZ01 - 3
	// input : area, price
	// output : List<Estate>
	public List<RealEstate> selectRealEstateListByAreaAndPrice(@Param("area") int area, @Param("price") int price);
	
} // public interface EstateMapper