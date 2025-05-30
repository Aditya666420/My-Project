package com.example.project.dtos;



public class TableDTO {
	
	private int tableNumber;
	private int cap;
	
	public TableDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TableDTO(int tableNumber, int cap) {
		super();
		this.tableNumber = tableNumber;
		this.cap = cap;
	}
	public int getTableNumber() {
		return tableNumber;
	}
	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}
	public int getCap() {
		return cap;
	}
	public void setCap(int cap) {
		this.cap = cap;
	}
	

}
