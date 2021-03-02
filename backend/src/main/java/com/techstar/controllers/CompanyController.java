package com.techstar.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.techstar.entities.Company;
import com.techstar.services.CompanyService;
import com.techstar.services.FounderService;

@CrossOrigin
@RestController
@RequestMapping("/companies")
public class CompanyController {

	@Autowired
	private CompanyService service;
	
	@Autowired
	private FounderService founderService;

	@GetMapping
	public ResponseEntity<List<Company>> findAll(){		
		List<Company> list = service.findAll();
		return ResponseEntity.ok().body(list);		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Company> findById(@PathVariable Long id){
		Company obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Company> insert(@RequestBody Company obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		Company comp = service.findById(id);
		comp.getFounders().forEach(f -> {
			founderService.delete(f.getId());
		});
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Company> update(@PathVariable Long id, @RequestBody Company obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
