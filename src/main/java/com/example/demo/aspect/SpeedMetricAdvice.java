package com.example.demo.aspect;

import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class SpeedMetricAdvice {

    @Around("@annotation(SpeedMetric)")
    @SneakyThrows
    public Object measureSpeed(ProceedingJoinPoint joinPoint) {
        long startTime = System.currentTimeMillis();
        Object object = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        System.out.println(joinPoint.getSignature().getName() + " " + (endTime - startTime));
        return object;
    }
}
