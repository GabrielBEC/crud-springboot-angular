package com.techstar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techstar.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
	
}
