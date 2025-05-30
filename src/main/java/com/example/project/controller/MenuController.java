package com.example.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.dtos.MenuItemDto;
import com.example.project.entity.MenuItem;
import com.example.project.services.MenuService;

@RestController
@RequestMapping("/menu-items")
public class MenuController {
	
	@Autowired
	private MenuService service;
	
	@PostMapping
	public MenuItem createItem(@RequestBody MenuItemDto dto) {
		
		return service.createItem(dto);
	}
	@GetMapping
	public List<MenuItemDto> getAll(){
		return service.getAll();
	}

}
