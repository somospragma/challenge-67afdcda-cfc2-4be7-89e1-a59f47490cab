package com.pragma.eventos.application.usecase;

import com.pragma.eventos.domain.model.Evento;
import com.pragma.eventos.domain.port.EventoProcessor;
import com.pragma.eventos.domain.port.EventoRepository;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.reactor.circuitbreaker.operator.CircuitBreakerOperator;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EventoUseCase {

    private final EventoRepository eventoRepository;
    private final EventoProcessor eventoProcessor;
    private final CircuitBreaker circuitBreaker;

    public EventoUseCase(EventoRepository eventoRepository, EventoProcessor eventoProcessor, CircuitBreakerRegistry circuitBreakerRegistry) {
        this.eventoRepository = eventoRepository;
        this.eventoProcessor = eventoProcessor;
        this.circuitBreaker = circuitBreakerRegistry.circuitBreaker("eventoCircuitBreaker");
    }

    public Mono<Evento> procesarEvento(Evento evento) {
        return eventoProcessor.procesarEvento(evento)
               .transform(CircuitBreakerOperator.of(circuitBreaker));
    }

    public Flux<Evento> procesarEventos(Flux<Evento> eventos) {
        return eventos.flatMap(this::procesarEvento);
    }

    public Mono<Void> iniciarProcesamientoContinuo() {
        return eventoProcessor.iniciarProcesamientoContinuo();
    }

    public Mono<Long> contarEventosProcesados() {
        return eventoProcessor.contarEventosProcesados();
    }

    public Mono<Long> contarEventosFallidos() {
        return eventoProcessor.contarEventosFallidos();
    }
}