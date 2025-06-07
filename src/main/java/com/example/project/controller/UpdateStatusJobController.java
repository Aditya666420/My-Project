package com.example.project.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jobs")
public class UpdateStatusJobController {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job orderStatusUpdateJob;  // Make sure this matches your job bean name

    @PostMapping("/update-status")
    public String runUpdateStatusJob(@RequestParam(defaultValue = "") String requestId) {
        try {
            JobParameters params = new JobParametersBuilder()
                    .addLong("timestamp", System.currentTimeMillis()) // to ensure uniqueness
                    .addString("requestId", requestId)
                    .toJobParameters();

            JobExecution execution = jobLauncher.run(orderStatusUpdateJob, params);
            return "Job started with status: " + execution.getStatus();
        } catch (Exception e) {
            return "Job failed to start: " + e.getMessage();
        }
    }
}
