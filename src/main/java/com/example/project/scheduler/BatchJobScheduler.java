package com.example.project.scheduler;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class BatchJobScheduler {

    private static final Logger logger = LoggerFactory.getLogger(BatchJobScheduler.class);
    @Autowired
    private  JobLauncher jobLauncher;
    @Autowired
    private  Job orderStatusUpdateJob;

    @Scheduled(cron = "0 0 0 * * *") 
    public void runJob() {
        try {
            logger.info("Triggering scheduled batch job at {}", new Date());

            JobParameters jobParameters = new JobParametersBuilder()
                    .addLong("runId", System.currentTimeMillis()) // unique parameter
                    .toJobParameters();

            JobExecution execution = jobLauncher.run(orderStatusUpdateJob, jobParameters);
            logger.info("Batch job executed with status: {}", execution.getStatus());
        } catch (Exception e) {
            logger.error("Batch job failed", e);
        }
    }
}
