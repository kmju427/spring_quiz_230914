package com.quiz.lesson07.bo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson07.entity.CompanyEntity;
import com.quiz.lesson07.repository.CompanyRepository;

@Service
public class CompanyBO {

	@Autowired
	private CompanyRepository companyRepository;
	
	// Quiz01 - 1
	public CompanyEntity addCompany(String name, String business, String scale, int headcount) {
		return companyRepository.save(CompanyEntity.builder()
										.name(name)
										.business(business)
										.scale(scale)
										.headcount(headcount)
										.build());
	}
	
	// Quiz01 - 2
	public CompanyEntity updateCompanyScaleHeadcountById(int id, String scale, int headcount) {
		// select
		CompanyEntity company = companyRepository.findById(id).orElse(null);
		
		// update
		if (company != null) {
			company = company.toBuilder()
					.scale(scale)
					.headcount(headcount)
					.build();
			
			company = companyRepository.save(company);
		}
		
		return company;
	}
	
	// Quiz01 - 3
	public void deleteCompanyById(int id) {
		// delete
		Optional<CompanyEntity> companyOptional = companyRepository.findById(id);
		companyOptional.ifPresent(c -> companyRepository.delete(c));
	}
	
} // public class CompanyBO