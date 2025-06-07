package com.example.project.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.example.project.entity.FoodOrder;
@Component
public class BatchProcessor implements ItemProcessor<FoodOrder, FoodOrder> {

	@Override
	public FoodOrder process(FoodOrder item) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(item);
		item.setStatus("Completed");
		return item;
	}

}
