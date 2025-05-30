package com.example.project.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.dtos.FoodReq;
import com.example.project.dtos.FoodResp;
import com.example.project.entity.FoodOrder;
import com.example.project.entity.MenuItem;
import com.example.project.entity.RestaurantTable;
import com.example.project.repository.MenuRepo;
import com.example.project.repository.OrderRepo;
import com.example.project.repository.TableRepo;

@Service
public class OrderService {
	@Autowired
	OrderRepo orderRepo;
	
	@Autowired
	TableRepo tableRepo;
	
	@Autowired
	MenuRepo menuRepo;
	
	public String create(FoodReq req) {
		 List<FoodOrder>orderList=orderRepo.findAll();
		 int c = 0;
		if(orderList.size()!=0 ) {
			c = numberOfOrdersForTable(orderList,req.getTableID());
		}
		FoodOrder ord = new FoodOrder();
		RestaurantTable table = tableRepo.findById(req.getTableID()).orElse(null);
		ord.setTable(table);
		List<MenuItem> itemsOrders = new ArrayList<>();
		for(Long id: req.getItemIds()) {
				MenuItem item = menuRepo.findById(id).orElse(null);
				if(item!= null) {
					itemsOrders.add(item);
				}
			
		}
		if(itemsOrders.size()+c>5) {
			return "Cannot Order more than 5 items";
		}
		ord.setItems(itemsOrders);
		ord.setOrderTime(LocalDateTime.now());
		ord.setStatus("PENDING");
		orderRepo.save(ord);
		return "Ordered saved SuccessFully";
		
	}
	public List<FoodResp> getAll() {
		List<FoodOrder> ordList = orderRepo.findAll();
		List<FoodResp> respL = new ArrayList<>();
		for(FoodOrder ord : ordList) {
			FoodResp resp = new FoodResp();
			resp.setItems(ord.getItems());
			resp.setOrderTime(ord.getOrderTime());
			resp.setTable(ord.getTable());
			resp.setAmount(getAmountById(ord.getId()));
			resp.setStatus(ord.getStatus());
			respL.add(resp);
			
		}
		return respL;
			
	}
	public double getAmountById(Long id) {
		FoodOrder order = orderRepo.findById(id).orElseThrow();
		double sum =0.0;
		for(MenuItem item:order.getItems()) {
			sum += item.getPrice();
		}
		return sum;
	}
	public String getAmountByTablenumber(Long id) {
		List<FoodOrder> order = orderRepo.findAll();
		double sum =0.0;
		for(FoodOrder ord : order) {
			if(ord.getTable().getId()==id) {
				for(MenuItem item:ord.getItems()) {
					sum += item.getPrice();
				}
			}
		}
		if (sum==0.0) {
			return "No order for table";
		}
		return "Price for table id "+id+" is "+sum;
	}
	public int numberOfOrdersForTable(List<FoodOrder> o,Long id) {
		int count =0;
		for(FoodOrder item: o) {
			if(id==item.getTable().getId()) {
				count += item.getItems().size();
			}
		}
		return count;
	}
	

}
