package com.quiz.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.quiz.lesson07.entity.RecruitEntity;

public interface RecruitRepository extends JpaRepository<RecruitEntity, Integer> {
	// 1. ID로 조회
	
	// JPQL -> Entity 조회
	// 2. Parameter 조건 조회
	public List<RecruitEntity> findByCompanyId(int companyId);
	
	// 3. 복합 조건 조회
	public List<RecruitEntity> findByPositionAndType(String position, String type);
	
	// 4. 복합 조건 조회
	public List<RecruitEntity> findByTypeOrSalaryGreaterThanEqual(String type, int salary);
	
	// 5. 정렬 제한 조건
	public List<RecruitEntity> findTop3ByTypeOrderBySalaryDesc(String type);
	
	// 6. 범위 조회
	public List<RecruitEntity> findByRegionAndSalaryBetween(String region, int salaryStart, int salaryEnd);
	
	// 7. Native query
	@Query(value = "select * from `recruit` " 
			+ "where `deadline` > :deadline " 
			+ "and `salary` >= :salary " 
			+ "and `type` = :type " 
			+ "order by `salary` DESC", nativeQuery = true)
	public List<RecruitEntity> findDeadlineSalaryType(
			@Param("deadline") String deadline, 
			@Param("salary") int salary, 
			@Param("type") String type);
} // public interface RecruitRepository