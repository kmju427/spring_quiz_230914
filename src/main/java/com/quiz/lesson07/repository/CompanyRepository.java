package com.quiz.lesson07.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.lesson07.entity.CompanyEntity;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer> {
	// Spring data JPA
	
	// 1. Insert
	// Entity 객체 save(Entity 객체);
	
	// 2. Update
	// Optional<Entity> findById(id);
	
	// 3. Delete(ID가 있음)
	// void delete(Entity 객체)
} // public interface CompanyRepository