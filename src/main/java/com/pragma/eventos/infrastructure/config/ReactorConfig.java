package com.pragma.eventos.infrastructure.config;

import io.projectreactor.core.publisher.Schedulers;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReactorConfig {

    private static final int POOL_SIZE = 10;

    @Bean
    public ExecutorService eventoExecutorService() {
        return Executors.newFixedThreadPool(POOL_SIZE);
    }

    @Bean
    public Schedulers.CustomizableScheduler eventoScheduler(ExecutorService eventoExecutorService) {
        return Schedulers.fromExecutorService(eventoExecutorService);
    }
}