package com.example.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.dtos.FoodReq;
import com.example.project.dtos.FoodResp;
import com.example.project.entity.FoodOrder;
import com.example.project.services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	@PostMapping
	public String create(@RequestBody FoodReq req) {
		return service.create(req);
	}
	@GetMapping
	public List<FoodResp> getAll(){
		return service.getAll();
	}
	@GetMapping("/tables/{id}/bill")
	public String getAmt(@PathVariable Long id) {
		return service.getAmountByTablenumber(id);
	}
}
