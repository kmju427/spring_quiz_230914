package com.quiz.lesson03.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson03.domain.RealEstate;
import com.quiz.lesson03.mapper.RealEstateMapper;

@Service
public class RealEstateBO {

	@Autowired // DI : spring bean 객체
	private RealEstateMapper realEstateMapper;
	
	// QUIZ01 - 1
	// input : id
	// output : RealEstate(있거나 혹은 없거나)
	public RealEstate getRealEstateById(int id) {
		return realEstateMapper.selectRealEstateById(id);
	}
	
	// QUIZ01 - 2
	// input : rentPrice
	// output : List<RealEstate> (있거나 혹은 [])
	public List<RealEstate> getRealEstateListByRentPrice(int rentPrice) {
		return realEstateMapper.selectRealEstateListByRentPrice(rentPrice);
	}
	
	// QUIZ01 - 3
	// input : area, price
	// output : List<RealEstate>
	public List<RealEstate> getRealEstateListByAreaAndPrice(int area, int price) {
		return realEstateMapper.selectRealEstateListByAreaAndPrice(area, price);
	}
	
} // public class EstateBO