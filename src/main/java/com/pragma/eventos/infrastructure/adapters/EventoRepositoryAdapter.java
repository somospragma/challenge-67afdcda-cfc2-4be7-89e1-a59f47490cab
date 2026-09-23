package com.pragma.eventos.infrastructure.adapters;

import com.pragma.eventos.domain.model.Evento;
import com.pragma.eventos.domain.port.EventoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class EventoRepositoryAdapter implements EventoRepository {

    @Override
    public Mono<Evento> save(Evento evento) {
        // Implementación con Spring Data JPA
        return Mono.empty();
    }

    @Override
    public Mono<Evento> findById(UUID id) {
        // Implementación con Spring Data JPA
        return Mono.empty();
    }

    @Override
    public Flux<Evento> findAll() {
        // Implementación con Spring Data JPA
        return Flux.empty();
    }

    @Override
    public Flux<Evento> findByEstado(String estado) {
        // Implementación con Spring Data JPA
        return Flux.empty();
    }

    @Override
    public Flux<Evento> findByOrigen(String origen) {
        // Implementación con Spring Data JPA
        return Flux.empty();
    }

    @Override
    public Mono<Void> deleteById(UUID id) {
        // Implementación con Spring Data JPA
        return Mono.empty();
    }

    @Override
    public Flux<Evento> findEventosParaProcesar() {
        // Implementación con Spring Data JPA
        return Flux.empty();
    }
}