package com.salesianostriana.dam.Reserva_de_Salas_de_Estudiomo.service;

import com.salesianostriana.dam.Reserva_de_Salas_de_Estudiomo.dto.SalaDatails;
import com.salesianostriana.dam.Reserva_de_Salas_de_Estudiomo.model.Sala;
import com.salesianostriana.dam.Reserva_de_Salas_de_Estudiomo.repository.SalaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.PredicateSpecification;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class SalaService {

    private final SalaRepository salaRepository;

    public Page<Sala> filtar(Pageable pageable, SalaDatails salaDatails){
        return salaRepository.findBy(
                PredicateSpecification.allOf(
                        SalaSpec.filtarPorCapacida(salaDatails.capacidadMax(),salaDatails.capacidadMin()),
                        SalaSpec.filtarPorFecha(salaDatails.reserva().fecha()),
                        SalaSpec.filtrarPorHora(salaDatails.reserva().horaInicio(), salaDatails.reserva().horaFin()),
                        SalaSpec.filtarPorPlanta(salaDatails.planta()),
                        SalaSpec.filtraPorDisponible(),
                        SalaSpec.filtrarPorNombre(salaDatails.nombre())
                ),
                q -> q.page(pageable)
        );
    }

}
