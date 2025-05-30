package com.example.project.dtos;

import java.time.LocalDateTime;
import java.util.List;

import com.example.project.entity.MenuItem;
import com.example.project.entity.RestaurantTable;



public class FoodResp {
	
	private RestaurantTable table;
	private List<MenuItem> items;
	private LocalDateTime orderTime;
	private double amount;
	private String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public RestaurantTable getTable() {
		return table;
	}
	public void setTable(RestaurantTable table) {
		this.table = table;
	}
	public List<MenuItem> getItems() {
		return items;
	}
	public void setItems(List<MenuItem> items) {
		this.items = items;
	}
	public LocalDateTime getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(LocalDateTime orderTime) {
		this.orderTime = orderTime;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public FoodResp(RestaurantTable table, List<MenuItem> items, LocalDateTime orderTime, double amount,String status) {
		super();
		this.table = table;
		this.items = items;
		this.orderTime = orderTime;
		this.amount = amount;
		this.status=status;
	}
	public FoodResp() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
