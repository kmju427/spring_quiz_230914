package com.quiz.booking.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.booking.domain.Booking;
import com.quiz.booking.mapper.BookingMapper;

@Service
public class BookingBO {

	@Autowired
	private BookingMapper bookingMapper;
	
	// input : X / output : List<Booking>
	public List<Booking> getBookingList() {
		return bookingMapper.selectBookingList();
	}
	
	// input : id / output : 삭제 성공한 행의 수
	public int deleteBookingById(int id) {
		return bookingMapper.deleteBookingById(id);
	}
	
	// input : 파라미터들 / output : X
	public void addBooking(String name, String date, int day, int headcount, String phoneNumber) {
		bookingMapper.insertBooking(name, date, day, headcount, phoneNumber);
	}
	
	// input : name, phoneNumber / output : 일치하는 데이터 or X
	public Booking getBookingByNamePhoneNumber(String name, String phoneNumber) {
		return bookingMapper.selectBookingByNamePhoneNumber(name, phoneNumber);
	}
	
} // public class BookingBO