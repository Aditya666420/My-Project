package com.example.project.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Around("execution(* com.example.project.services.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().toShortString();
        System.out.println("➡️ Before executing: " + methodName);

        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();  // Execute the actual method
        long endTime = System.currentTimeMillis();

        System.out.println("⬅️ After executing: " + methodName);
        System.out.println("⏱ Execution time: " + (endTime - startTime) + " ms");

        return result;
    }
}

