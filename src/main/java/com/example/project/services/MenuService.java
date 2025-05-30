package com.example.project.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.dtos.MenuItemDto;
import com.example.project.entity.MenuItem;
import com.example.project.repository.MenuRepo;

@Service
public class MenuService {
	
	@Autowired
	private MenuRepo repo;
	
	
	public MenuItem createItem(MenuItemDto dto) {
		
		MenuItem item = new MenuItem();
		item.setName(dto.getName());
		item.setPrice(dto.getPrice());
		return repo.save(item);
	}
	public List<MenuItemDto> getAll() {
		
		List<MenuItem> items = repo.findAll();
		List<MenuItemDto> dtoList = new ArrayList<>();
		for(MenuItem item : items) {
			MenuItemDto dto = new MenuItemDto(item.getName(),item.getPrice());
			dtoList.add(dto);
		}
		return dtoList;
		
	}

}
