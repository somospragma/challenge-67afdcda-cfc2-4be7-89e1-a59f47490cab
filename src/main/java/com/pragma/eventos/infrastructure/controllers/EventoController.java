package com.pragma.eventos.infrastructure.controllers;

import com.pragma.eventos.domain.model.Evento;
import com.pragma.eventos.domain.port.EventoProcessor;
import com.pragma.eventos.infrastructure.dto.EventoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {

    @Autowired
    private EventoProcessor eventoProcessor;

    @PostMapping
    public Mono<ResponseEntity<EventoDTO>> recibirEvento(@RequestBody Evento evento) {
        return eventoProcessor.procesarEvento(evento)
               .map(e -> ResponseEntity.status(HttpStatus.CREATED).body(new EventoDTO(e)))
               .onErrorResume(e -> Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<EventoDTO>> obtenerEstadoEvento(@PathVariable UUID id) {
        return eventoProcessor.findById(id)
               .map(e -> ResponseEntity.ok(new EventoDTO(e)))
               .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()))
               .onErrorResume(e -> Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()));
    }
}