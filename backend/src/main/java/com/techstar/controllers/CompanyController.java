package com.techstar.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techstar.entities.Company;
import com.techstar.services.CompanyService;

@RestController
@RequestMapping("/companies")
public class CompanyController {

	@Autowired
	private CompanyService service;

	@GetMapping
	public ResponseEntity<List<Company>> read(){		
		List<Company> list = service.findAll();
		return ResponseEntity.ok().body(list);		
	}
}
