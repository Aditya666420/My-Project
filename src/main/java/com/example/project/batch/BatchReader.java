package com.example.project.batch;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.project.entity.FoodOrder;
import com.example.project.repository.OrderRepo;

@Component
@StepScope  //Re-Initialize the reader everytime
public class BatchReader implements ItemReader<FoodOrder>{

	private Iterator<FoodOrder> orderIterator;
	
	@Autowired
	OrderRepo orderRepo;

    @Override
    public FoodOrder read() {
    	List<String> statuses = Arrays.asList("PENDING","UNDELIVERED","FAILED");
        if (orderIterator == null) {
            List<FoodOrder> orders = orderRepo.findByStatusInAndOrderTimeBefore(statuses, LocalDateTime.now().minusMinutes(1));
            System.out.println(orders);
            orderIterator = orders.iterator();
        }
        return orderIterator.hasNext() ? orderIterator.next() : null;
    }

}


