package com.pragma.eventos.infrastructure.config;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.springboot3.circuitbreaker.annotation.CircuitBreakerConfigs;
import io.github.resilience4j.springboot3.retry.annotation.RetryConfigs;
import io.github.resilience4j.springboot3.ratelimiter.annotation.RateLimiterConfigs;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Resilience4jConfig {

    @Bean
    @CircuitBreakerConfigs
    public CircuitBreakerConfig customCircuitBreakerConfig() {
        return CircuitBreakerConfig.custom()
               .failureRateThreshold(50)
               .waitDurationInOpenState(java.time.Duration.ofSeconds(60))
               .build();
    }

    @Bean
    @RetryConfigs
    public RetryConfig customRetryConfig() {
        return RetryConfig.custom()
               .maxAttempts(3)
               .waitDuration(java.time.Duration.ofSeconds(1))
               .build();
    }

    @Bean
    @RateLimiterConfigs
    public RateLimiterConfig customRateLimiterConfig() {
        return RateLimiterConfig.custom()
               .limitForPeriod(10)
               .limitRefreshPeriod(java.time.Duration.ofSeconds(1))
               .timeoutDuration(java.time.Duration.ofSeconds(2))
               .build();
    }
}