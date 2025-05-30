package com.example.project.dtos;

public class MenuItemDto {
	String name;
	double price;
	
	public MenuItemDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MenuItemDto(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	


}
