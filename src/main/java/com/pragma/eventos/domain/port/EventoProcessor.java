package com.pragma.eventos.domain.port;

import com.pragma.eventos.domain.model.Evento;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EventoProcessor {
    Mono<Evento> procesarEvento(Evento evento);
    Flux<Evento> procesarEventos(Flux<Evento> eventos);
    Mono<Void> iniciarProcesamientoContinuo();
    Mono<Long> contarEventosProcesados();
    Mono<Long> contarEventosFallidos();
}