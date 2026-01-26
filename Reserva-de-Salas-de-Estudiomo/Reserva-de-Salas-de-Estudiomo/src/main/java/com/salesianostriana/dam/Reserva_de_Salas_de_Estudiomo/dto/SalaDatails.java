package com.salesianostriana.dam.Reserva_de_Salas_de_Estudiomo.dto;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalTime;

public record SalaDatails(
        Integer planta,
        String nombre,
        Integer capacidadMax,
        Integer capacidadMin,
        boolean disponible,
        reservaSimple reserva

) {
    public record reservaSimple(
            LocalTime horaInicio,
            LocalTime horaFin,
            LocalDate fecha
    ){
    }
}
