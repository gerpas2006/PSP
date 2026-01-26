package com.salesianostriana.dam.Reserva_de_Salas_de_Estudiomo.dto;

import com.salesianostriana.dam.Reserva_de_Salas_de_Estudiomo.model.EstadoReserva;


import java.time.LocalDate;
import java.time.LocalTime;

public record ReservaResponse(
        Long id,
        salaSimple salaNombre,
        usuarioSimple usuarioNombre,
        LocalDate fecha,
        LocalTime horaInicio,
        LocalTime horaFin,
        EstadoReserva estadoReserva
) {
    public record usuarioSimple(
            String usuarioNombre
    ){}

    public record salaSimple(
            String salaNombre
    ){}
}
