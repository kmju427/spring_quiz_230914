package com.quiz.lesson04.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.lesson04.domain.Seller;

@Mapper
public interface SellerMapper {
	
	// input : nickname, profileImageUrl, temperature
	// output : X
	public void insertSeller(
			@Param("nickname") String nickname, 
			@Param("profileImageUrl") String profileImageUrl, 
			@Param("temperature") double temperature);
	
	// input : X
	// output : Seller(있거나 or null)
	public Seller selectLatestSeller();
	
	// input : id
	// output : Seller(있거나 or null)
	public Seller selectSellerById(int id);

} // public interface SellerMapper