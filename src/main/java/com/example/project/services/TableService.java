package com.example.project.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.dtos.TableDTO;
import com.example.project.entity.RestaurantTable;
import com.example.project.repository.TableRepo;

@Service
public class TableService {

	@Autowired
	private TableRepo repo;
	
	public RestaurantTable createTable(TableDTO table) {
		RestaurantTable rst = new RestaurantTable();
		rst.setTableNumber(table.getTableNumber());
		rst.setCapacity(table.getCap());
		return repo.save(rst);
	}
	public List<TableDTO> getAll(){
		List<RestaurantTable> rl = repo.findAll();
		List<TableDTO> dtoList = new ArrayList<>();
		for(RestaurantTable item:rl) {
			TableDTO dto = new TableDTO(item.getTableNumber(),item.getCapacity());
			dtoList.add(dto);
		}
		return dtoList;
		
	}
}
