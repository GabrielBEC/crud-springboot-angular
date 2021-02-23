package com.techstar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techstar.entities.Company;
import com.techstar.repositories.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository repository;
	
	public List<Company> findAll(){
		return repository.findAll();
	}
	
	public Company findById(Long id) {
		Optional<Company> obj = repository.findById(id);
		return obj.get();
	}
	
	public Company insert(Company obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Company update(Long id, Company obj) {
		Company entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);		
	}
	
	public void updateData(Company entity, Company obj) {
		entity.setName(obj.getName());
		entity.setLocation(obj.getLocation());
		entity.setDescription(obj.getDescription());
		entity.setFoundedDate(obj.getFoundedDate());
	}
}
