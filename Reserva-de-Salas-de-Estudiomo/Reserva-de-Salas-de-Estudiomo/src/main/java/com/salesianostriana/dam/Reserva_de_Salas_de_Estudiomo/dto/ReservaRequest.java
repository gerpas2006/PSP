package com.salesianostriana.dam.Reserva_de_Salas_de_Estudiomo.dto;

import org.springframework.cglib.core.Local;

import java.time.LocalTime;

public record ReservaRequest(
        Long salaId,
        Long usuarioId,
        LocalTime horaInicio,
        LocalTime horaFin
) {
}
