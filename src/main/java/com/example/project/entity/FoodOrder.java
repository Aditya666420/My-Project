package com.example.project.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "FoodOrder")
public class FoodOrder {
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		@ManyToOne
		private RestaurantTable table;
		@ManyToMany
		private List<MenuItem> items;
		private LocalDateTime orderTime;
		private String status;
		
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public FoodOrder() {
			super();
			// TODO Auto-generated constructor stub
		}
		public FoodOrder(Long id, RestaurantTable table, List<MenuItem> items, LocalDateTime orderTime,String status) {
			super();
			this.id = id;
			this.table = table;
			this.items = items;
			this.orderTime = orderTime;
			this.status=status;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
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
		
}
