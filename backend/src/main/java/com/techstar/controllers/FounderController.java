package com.techstar.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techstar.entities.Founder;
import com.techstar.services.FounderService;

@RestController
@RequestMapping("/founders")
public class FounderController {

	@Autowired
	private FounderService service;
	
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
}
