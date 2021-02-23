package com.techstar.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.techstar.entities.Company;
import com.techstar.entities.Founder;
import com.techstar.services.CompanyService;
import com.techstar.services.FounderService;

@RestController
@RequestMapping("/founders")
public class FounderController {

	@Autowired
	private FounderService service;
	
	@Autowired
	private CompanyService companyService;
	
	@GetMapping
	public ResponseEntity<List<Founder>> findAll(){
		List<Founder> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Founder> findById(@PathVariable Long id){
		Founder obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Founder> insert(@RequestBody Founder obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Founder> insertInCompany(@RequestBody Founder obj, @PathVariable Long id, Company comp){
		obj = service.insert(obj);
		comp = companyService.findById(id);
		obj.setCompany(comp);
		companyService.update(id, comp);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
}
