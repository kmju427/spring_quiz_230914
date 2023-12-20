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
	// output : List<RealEstate> (있거나 혹은 [])
	// getRealEstateListByAreaAndPrice or getRealEstateListByAreaPrice (And 생략해도 된다.)
	public List<RealEstate> getRealEstateListByAreaAndPrice(int area, int price) {
		return realEstateMapper.selectRealEstateListByAreaAndPrice(area, price);
	}
	
	// QUIZ02 - 1
	// input : RealEstate
	// output : 성공한 행의 개수(int)
	public int addRealEstate(RealEstate realEstate) {
		return realEstateMapper.insertRealEstate(realEstate);
	}
	
	// QUIZ02 - 2
	// input : addRealEstateAsField(realtorId, "썅떼빌리버 오피스텔 814호", 45, "월세", 100000, 120)
	// output : 성공한 행의 개수(int)
	public int addRealEstateAsField(int realtorId, String address, int area, String type, int price, Integer rentPrice) {
		return realEstateMapper.insertRealEstateAsField(realtorId, address, area, type, price, rentPrice) ;
	}
	
	// QUIZ03 - 1
	// input : id, type, price
	// output : 성공한 행의 개수(int)
	public int updateRealEstateById(int id, String type, int price) {
		return realEstateMapper.updateRealEstateById(id, type, price);
	}
	
	// QUIZ04 - 1
	// input : id
	// output : 성공한 행의 개수(int)
	public int deleteRealEstateById(int id) {
		return realEstateMapper.deleteRealEstateById(id);
	}
	
} // public class EstateBO