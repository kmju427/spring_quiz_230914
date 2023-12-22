package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson04.bo.RealtorBO;
import com.quiz.lesson04.domain.Realtor;

@RequestMapping("/lesson04/quiz02")
@Controller
public class Lesson04Quiz02Controller {

	@Autowired
	private RealtorBO realtorBO;
	
	// 공인중개사 추가
	// URL : http://localhost:8080/lesson04/quiz02/add-realtor-view
	@GetMapping("/add-realtor-view")
	public String addRealtorView() {
		return "lesson04/addRealtor";
	}
	
	// 공인중개사 추가 insert & 방금 추가된 공인중개사 데이터 화면
	@PostMapping("/add-realtor")
	public String addRealtor(
			@ModelAttribute Realtor realtor,
			Model model) {
		// DB insert => 방금 추가된 정보 pk 받아오기 => realtor에 세팅
		realtorBO.addRealtor(realtor);
		
		// realtor에 세팅된 id로 객체 다시 조회(방금 추가된 정보)
		Realtor latestRealtor = realtorBO.getRealtorById(realtor.getId());
		
		// model에 담기
		model.addAttribute("realtor", latestRealtor);
		
		// jsp 화면으로 이동
		return "lesson04/afterAddRealtor";
	}
	
} // public class Lesson04Quiz02Controller