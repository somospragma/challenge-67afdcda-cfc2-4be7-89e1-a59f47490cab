package com.pragma.eventos.infrastructure.controllers;

import com.pragma.eventos.domain.model.Evento;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest
@AutoConfigureWebTestClient
class EventoControllerIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreateEvent() {
        Evento evento = new Evento(UUID.randomUUID(), "tipo", "origen", "timestamp");
        webTestClient.post()
               .uri("/eventos")
               .bodyValue(evento)
               .exchange()
               .expectStatus().isCreated()
               .expectBody(Evento.class);
    }

    @Test
    void testGetEventById() {
        UUID id = UUID.randomUUID();
        webTestClient.get()
               .uri("/eventos/" + id)
               .exchange()
               .expectStatus().isOk()
               .expectBody(Evento.class);
    }

    @Test
    void testGetAllEvents() {
        webTestClient.get()
               .uri("/eventos")
               .exchange()
               .expectStatus().isOk()
               .expectBodyList(Evento.class);
    }
}