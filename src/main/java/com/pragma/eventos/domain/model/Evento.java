package com.pragma.eventos.domain.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record Evento(
    UUID id,
    String tipo,
    String origen,
    Instant timestamp,
    BigDecimal monto,
    String estado,
    String metadata
) {
    public static final String ESTADO_PENDIENTE = "PENDIENTE";
    public static final String ESTADO_PROCESADO = "PROCESADO";
    public static final String ESTADO_FALLIDO = "FALLIDO";

    public Evento {
        if (id == null) {
            throw new IllegalArgumentException("El id del evento no puede ser nulo");
        }
        if (tipo == null || tipo.isBlank()) {
            throw new IllegalArgumentException("El tipo del evento no puede ser nulo o vacío");
        }
        if (origen == null || origen.isBlank()) {
            throw new IllegalArgumentException("El origen del evento no puede ser nulo o vacío");
        }
        if (timestamp == null) {
            throw new IllegalArgumentException("El timestamp del evento no puede ser nulo");
        }
        if (monto != null && monto.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El monto no puede ser negativo");
        }
    }

    public Evento conEstado(String nuevoEstado) {
        return new Evento(this.id, this.tipo, this.origen, this.timestamp, this.monto, nuevoEstado, this.metadata);
    }

    public boolean esDeAltoRiesgo() {
        return "MOTOR_ANTIFRAUDE".equals(this.origen) && this.monto != null && this.monto.compareTo(new BigDecimal("10000")) > 0;
    }

    public boolean requiereProcesamientoPrioritario() {
        return "GATEWAY_PAGOS".equals(this.origen);
    }
}