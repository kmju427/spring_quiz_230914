package com.quiz.lesson03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.lesson03.domain.RealEstate;

@Mapper
public interface RealEstateMapper {

	// QUIZ01 - 1
	// input : id
	// output : RealEstate
	public RealEstate selectRealEstateById(int id);
	
	// QUIZ01 - 2
	// input : rentPrice
	// output : List<RealEstate>
	public List<RealEstate> selectRealEstateListByRentPrice(int rentPrice);
	
	// QUIZ01 - 3
	// input : area, price
	// output : List<RealEstate>
	// MyBatis 문법 상 파라미터는 단 한 개만 .xml로 보낼 수 있다.   
	// 파라미터들을 하나의 맵에 담아서 보낸다. -> 맵으로 만들어주는 어노테이션 : @Param
	// .xml에서는 변수명으로 받는 것이 아닌 키명으로 받는다.
	// .xml에서 파라미터타입은 생략해도 되나 적게 된다면 map으로 받아야 한다.
	public List<RealEstate> selectRealEstateListByAreaAndPrice(
			@Param("area") int area, @Param("price") int price);
	
	// QUIZ02 - 1
	// input : RealEstate
	// output : 성공한 행의 개수(int)
	public int insertRealEstate(RealEstate realEstate);
	
	// QUIZ02 - 2
	// input : addRealEstateAsField(realtorId, "썅떼빌리버 오피스텔 814호", 45, "월세", 100000, 120)
	// output : 성공한 행의 개수(int)
	public int insertRealEstateAsField(
			@Param("realtorId") int realtorId, 
			@Param("address") String address, 
			@Param("area") int area, 
			@Param("type") String type, 
			@Param("price") int price, 
			@Param("rentPrice") Integer rentPrice);
	
	// QUIZ03 - 1
	// input : id, type, price
	// output : 성공한 행의 개수(int)
	public int updateRealEstateById(
			@Param("id") int id, 
			@Param("type") String type, 
			@Param("price") int price);
	
	// QUIZ04 - 1
	// input : id
	// output : 성공한 행의 개수(int)
	public int deleteRealEstateById(int id);
	
} // public interface EstateMapper