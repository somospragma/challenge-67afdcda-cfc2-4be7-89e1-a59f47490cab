package com.pragma.eventos.domain.port;

import com.pragma.eventos.domain.model.Evento;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.UUID;

public interface EventoRepository {
    Mono<Evento> save(Evento evento);
    Mono<Evento> findById(UUID id);
    Flux<Evento> findAll();
    Flux<Evento> findByEstado(String estado);
    Flux<Evento> findByOrigen(String origen);
    Mono<Void> deleteById(UUID id);
    Flux<Evento> findEventosParaProcesar();
}