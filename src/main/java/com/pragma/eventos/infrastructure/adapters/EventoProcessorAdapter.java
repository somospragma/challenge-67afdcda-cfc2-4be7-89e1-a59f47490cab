package com.pragma.eventos.infrastructure.adapters;

import com.pragma.eventos.domain.model.Evento;
import com.pragma.eventos.domain.port.EventoProcessor;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.reactor.circuitbreaker.operator.CircuitBreakerOperator;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class EventoProcessorAdapter implements EventoProcessor {

    private final CircuitBreaker circuitBreaker;

    public EventoProcessorAdapter(CircuitBreakerRegistry circuitBreakerRegistry) {
        this.circuitBreaker = circuitBreakerRegistry.circuitBreaker("eventoCircuitBreaker");
    }

    @Override
    public Mono<Evento> procesarEvento(Evento evento) {
        // Implementación con Reactor y Resilience4j
        return Mono.just(evento);
    }

    @Override
    public Flux<Evento> procesarEventos(Flux<Evento> eventos) {
        return eventos.flatMap(this::procesarEvento);
    }

    @Override
    public Mono<Void> iniciarProcesamientoContinuo() {
        // Implementación con Reactor y Resilience4j
        return Mono.empty();
    }

    @Override
    public Mono<Long> contarEventosProcesados() {
        // Implementación con Reactor y Resilience4j
        return Mono.just(0L);
    }

    @Override
    public Mono<Long> contarEventosFallidos() {
        // Implementación con Reactor y Resilience4j
        return Mono.just(0L);
    }
}