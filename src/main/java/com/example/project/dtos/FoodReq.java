package com.example.project.dtos;

import java.util.List;

public class FoodReq {
	
	private Long tableID;
	private List<Long> itemIds;
	
	public FoodReq() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FoodReq(Long tableID, List<Long> itemIds) {
		super();
		this.tableID = tableID;
		this.itemIds = itemIds;
	}
	public Long getTableID() {
		return tableID;
	}
	public void setTableID(Long tableID) {
		this.tableID = tableID;
	}
	public List<Long> getItemIds() {
		return itemIds;
	}
	public void setItemIds(List<Long> itemIds) {
		this.itemIds = itemIds;
	}
	
	
}
	
	