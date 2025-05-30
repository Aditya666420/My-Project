package com.example.project.batch;

import com.example.project.entity.FoodOrder;
import com.example.project.repository.OrderRepo;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

@Configuration
public class BatchConfig {

   
    @Autowired
    private BatchProcessor processor;
    @Autowired
    private BatchReader reader;
    @Autowired
    private BatchWriter writer;

   

    @Bean
    public Job orderStatusUpdateJob(JobRepository jobRepository, Step updateStep) {
        return new JobBuilder("orderStatusUpdateJob", jobRepository)
                .start(updateStep)
                .build();
    }

    @Bean
    public Step updateStep(JobRepository jobRepository,
                           PlatformTransactionManager transactionManager
                           ) {
        return new StepBuilder("updateStep", jobRepository)
                .<FoodOrder, FoodOrder>chunk(10, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }
}
