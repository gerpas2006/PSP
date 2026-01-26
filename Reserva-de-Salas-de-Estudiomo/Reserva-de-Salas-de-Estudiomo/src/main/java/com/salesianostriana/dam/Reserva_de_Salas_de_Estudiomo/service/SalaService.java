package com.salesianostriana.dam.Reserva_de_Salas_de_Estudiomo.service;

import com.salesianostriana.dam.Reserva_de_Salas_de_Estudiomo.dto.SalaDatails;
import com.salesianostriana.dam.Reserva_de_Salas_de_Estudiomo.dto.SalaResponse;
import com.salesianostriana.dam.Reserva_de_Salas_de_Estudiomo.model.Sala;
import com.salesianostriana.dam.Reserva_de_Salas_de_Estudiomo.repository.SalaRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.Page;
import org.springframework.data.jpa.domain.PredicateSpecification;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.print.Pageable;
import java.time.LocalTime;

@Service
@RequiredArgsConstructor
public class SalaService {

    private final SalaRepository salaRepository;

//    public Page<Sala> filtar(Pageable pageable, SalaDatails salaDatails){
//        return salaRepository.findBy(
//                SalaSpec.filtarPorCapacida(salaDatails.capacidad()),
//                SalaSpec.filtarPorFecha(SalaDatails.reservaSimple)
//        ),
//        q -> q.pa
//    }

}
