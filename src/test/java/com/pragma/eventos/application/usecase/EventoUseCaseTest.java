package com.pragma.eventos.application.usecase;

import com.pragma.eventos.domain.model.Evento;
import com.pragma.eventos.domain.port.EventoProcessor;
import com.pragma.eventos.domain.port.EventoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class EventoUseCaseTest {

    @Mock
    private EventoRepository eventoRepository;

    @Mock
    private EventoProcessor eventoProcessor;

    @InjectMocks
    private EventoUseCase eventoUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testProcessEvent() {
        Evento evento = new Evento(UUID.randomUUID(), "tipo", "origen", "timestamp");
        when(eventoRepository.save(evento)).thenReturn(Mono.just(evento));
        when(eventoProcessor.procesarEvento(evento)).thenReturn(Mono.just(evento));

        StepVerifier.create(eventoUseCase.processEvent(evento))
               .expectNext(evento)
               .verifyComplete();
    }

    @Test
    void testProcessEvents() {
        Evento evento1 = new Evento(UUID.randomUUID(), "tipo1", "origen1", "timestamp1");
        Evento evento2 = new Evento(UUID.randomUUID(), "tipo2", "origen2", "timestamp2");
        when(eventoRepository.saveAll(any())).thenReturn(Mono.just(evento1));
        when(eventoProcessor.procesarEventos(any())).thenReturn(Mono.just(evento1));

        StepVerifier.create(eventoUseCase.processEvents(Flux.just(evento1, evento2)))
               .expectNext(evento1)
               .verifyComplete();
    }
}