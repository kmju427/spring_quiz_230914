package com.quiz.booking.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.booking.domain.Booking;

@Mapper
public interface BookingMapper {

	// input : X / output : List<Booking>
	public List<Booking> selectBookingList();
	
	// input : id / output : 삭제 성공한 행의 수
	public int deleteBookingById(int id);
	
	// input : 파라미터들 / output : X
	public void insertBooking(
			@Param("name") String name, 
			@Param("date") String date, 
			@Param("day") int day, 
			@Param("headcount") int headcount, 
			@Param("phoneNumber") String phoneNumber);
	
	// input : name, phoneNumber / output : List<Booking>
	public List<Booking> selectBookingListByNamePhoneNumber(
			@Param("name") String name, 
			@Param("phoneNumber") String phoneNumber);
	
} // public interface BookingMapper