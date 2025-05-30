package com.example.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.dtos.TableDTO;
import com.example.project.entity.RestaurantTable;
import com.example.project.services.TableService;

@RestController
@RequestMapping("/table")
public class TableController {
	
	@Autowired
	private TableService service;
	
	
	@PostMapping
	public RestaurantTable createTable(@RequestBody TableDTO dto) {
		return service.createTable(dto);
	}
	@GetMapping
	public List<TableDTO> getAll(){
		return service.getAll();
	}

}
