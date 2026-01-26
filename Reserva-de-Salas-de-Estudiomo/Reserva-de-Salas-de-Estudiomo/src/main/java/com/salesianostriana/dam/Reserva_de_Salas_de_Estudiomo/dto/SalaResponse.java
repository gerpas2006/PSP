package com.salesianostriana.dam.Reserva_de_Salas_de_Estudiomo.dto;

import com.salesianostriana.dam.Reserva_de_Salas_de_Estudiomo.model.Sala;

public record SalaResponse(
        Long id,
        String nombre,
        Integer planta,
        Integer capacidad,
        boolean disponible
) {
    public static SalaResponse of(Sala s){
        return new SalaResponse(
                s.getId(),
                s.getNombre(),
                s.getPlanta(),
                s.getCapacidad(),
                s.isDisponible()
        );
    }
}
