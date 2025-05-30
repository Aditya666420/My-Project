package com.example.project.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.entity.FoodOrder;

public interface OrderRepo extends JpaRepository<FoodOrder,Long>{
		List<FoodOrder> findByStatusAndOrderTimeBefore(String status,LocalDateTime orderTime);
}
