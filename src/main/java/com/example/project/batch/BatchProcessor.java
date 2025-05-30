package com.example.project.batch;

import java.time.LocalDateTime;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.example.project.entity.FoodOrder;
@Component
public class BatchProcessor implements ItemProcessor<FoodOrder, FoodOrder> {

	@Override
	public FoodOrder process(FoodOrder item) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(item);
		if (item != null  && item.getStatus().equals("PENDING") && item.getOrderTime().isBefore(LocalDateTime.now().minusMinutes(1))) {
			item.setStatus("Complete");
		}
		return item;
	}

}
