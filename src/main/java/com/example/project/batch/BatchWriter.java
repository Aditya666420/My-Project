package com.example.project.batch;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.project.entity.FoodOrder;
import com.example.project.repository.OrderRepo;

@Component
public class BatchWriter implements ItemWriter<FoodOrder> {
	
	@Autowired
	OrderRepo repo;

	@Override
	public void write(Chunk<? extends FoodOrder> chunk) throws Exception {
		// TODO Auto-generated method stub
		List<FoodOrder> orders = new ArrayList<>();
		for(FoodOrder order:chunk) {
			orders.add(order);
		}
		 repo.saveAll(orders);
		
	}

}
