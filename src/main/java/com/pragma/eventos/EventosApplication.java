package com.pragma.eventos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Hooks;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class EventosApplication {

    public static void main(String[] args) {
        // Configuración inicial de Reactor para mejores mensajes de error en caso de bloqueos
        Hooks.onOperatorDebug();
        SpringApplication.run(EventosApplication.class, args);
    }

    @Bean
    public ExecutorService eventoExecutorService() {
        // Pool de hilos dedicado para procesamiento de eventos
        return Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors() * 2,
            r -> {
                Thread t = new Thread(r, "evento-processor");
                t.setDaemon(true);
                return t;
            }
        );
    }

    @Bean
    public Schedulers.CustomizableScheduler eventoScheduler(ExecutorService eventoExecutorService) {
        return Schedulers.fromExecutorService(eventoExecutorService);
    }
}