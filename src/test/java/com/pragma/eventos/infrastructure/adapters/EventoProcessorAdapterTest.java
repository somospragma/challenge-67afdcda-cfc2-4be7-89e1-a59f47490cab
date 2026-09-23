package com.pragma.eventos.infrastructure.adapters;

import com.pragma.eventos.domain.model.Evento;
import com.pragma.eventos.domain.port.EventoProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class EventoProcessorAdapterTest {

    @Mock
    private EventoProcessor eventoProcessor;

    @InjectMocks
    private EventoProcessorAdapter eventoProcessorAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testProcessEvent() {
        Evento evento = new Evento(UUID.randomUUID(), "tipo", "origen", "timestamp");
        when(eventoProcessor.procesarEvento(evento)).thenReturn(Mono.just(evento));

        StepVerifier.create(eventoProcessorAdapter.processEvent(evento))
               .expectNext(evento)
               .verifyComplete();
    }

    @Test
    void testProcessEvents() {
        Evento evento1 = new Evento(UUID.randomUUID(), "tipo1", "origen1", "timestamp1");
        Evento evento2 = new Evento(UUID.randomUUID(), "tipo2", "origen2", "timestamp2");
        when(eventoProcessor.procesarEventos(any())).thenReturn(Flux.just(evento1));

        StepVerifier.create(eventoProcessorAdapter.processEvents(Flux.just(evento1, evento2)))
               .expectNext(evento1)
               .verifyComplete();
    }
}