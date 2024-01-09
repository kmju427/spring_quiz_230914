package com.quiz.lesson07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.entity.RecruitEntity;
import com.quiz.lesson07.repository.RecruitRepository;

@RequestMapping("/lesson07/quiz02")
@RestController
public class Lesson07Quiz02RestController {

	@Autowired
	private RecruitRepository recruitRepository;
	
	// 1. ID로 조회
	// 'id'가 8인 공고를 조회
	// http://localhost:8080/lesson07/quiz02/1
	@GetMapping("/1")
	public RecruitEntity quiz02_1() {
		return recruitRepository.findById(8).orElse(null);
	}
	
	// 2. Parameter 조건 조회
	// Request Parameter로 전달 받은 company id로 해당하는 회사의 공고를 조회
	// http://localhost:8080/lesson07/quiz02/2?companyId=1
	@GetMapping("/2")
	public List<RecruitEntity> quiz02_2(
			@RequestParam("companyId") int companyId) {
		return recruitRepository.findByCompanyId(companyId);
	}
	
	// 3. 복합 조건 조회
	// '웹 back-end 개발자(position)'이고 '정규직(type)'인 공고를 조회
	// http://localhost:8080/lesson07/quiz02/3
	@GetMapping("/3")
	public List<RecruitEntity> quiz02_3() {
		return recruitRepository.findByPositionAndType("웹 back-end 개발자", "정규직");
	}
	
	// 4. 복합 조건 조회
	// '정규직(type)'이거나 '연봉이 9000(salary)' 이상인 공고를 조회
	// http://localhost:8080/lesson07/quiz02/4
	@GetMapping("/4")
	public List<RecruitEntity> quiz02_4() {
		return recruitRepository.findByTypeOrSalaryGreaterThanEqual("정규직", 9000);
	}
	
	// 5. 정렬 제한 조건
	// '계약직' 목록을 '연봉' 기준으로 내림차순 정렬해서 3개만 조회
	// http://localhost:8080/lesson07/quiz02/5
	@GetMapping("/5")
	public List<RecruitEntity> quiz02_5() {
		return recruitRepository.findTop3ByTypeOrderBySalaryDesc("계약직");
	}
	
	// 6. 범위 조회
	// '성남시 분당구(region)'가 지역인 '연봉 7000 이상 8500 이하(salary)'인 공고를 조회
	// http://localhost:8080/lesson07/quiz02/6
	@GetMapping("/6")
	public List<RecruitEntity> quiz02_6() {
		return recruitRepository.findByRegionAndSalaryBetween("성남시 분당구", 7000, 8500);
	}
	
	// 7. Native query
	// '마감일이 2026-04-10 이후(deadline)'이고 '연봉이 8100 이상(salary)'인 '정규직(type)' 공고를 연봉 내림차순으로 조회
	// http://localhost:8080/lesson07/quiz02/7
	@GetMapping("/7")
	public List<RecruitEntity> quiz02_7() {
		return recruitRepository.findDeadlineSalaryType("2026-04-10", 8100, "정규직");
	}
	
} // public class Lesson07Quiz02RestController