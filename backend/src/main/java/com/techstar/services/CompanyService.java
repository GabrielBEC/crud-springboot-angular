package com.techstar.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techstar.entities.Company;
import com.techstar.repositories.CompanyRepository;
import com.techstar.services.exceptions.ResourceNotFoundException;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository repository;
	
	public List<Company> findAll(){
		return repository.findAll();
	}
	
	public Company findById(Long id) {
		Optional<Company> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Company insert(Company obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Company update(Long id, Company obj) {
		try {
			Company entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);					
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public void updateData(Company entity, Company obj) {
		entity.setName(obj.getName());
		entity.setLocation(obj.getLocation());
		entity.setDescription(obj.getDescription());
		entity.setFoundedDate(obj.getFoundedDate());
	}
}
