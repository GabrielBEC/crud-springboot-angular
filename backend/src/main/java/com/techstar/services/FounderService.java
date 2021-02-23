package com.techstar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techstar.entities.Founder;
import com.techstar.repositories.FounderRepository;

@Service
public class FounderService {

	@Autowired
	private FounderRepository repository;
	
	public List<Founder> findAll(){
		return repository.findAll();
	}
	
	public Founder findById(Long id) {
		Optional<Founder> obj = repository.findById(id);
		return obj.get();
	}
	
	public Founder insert(Founder obj) {
		return repository.save(obj);
	}
	
}
