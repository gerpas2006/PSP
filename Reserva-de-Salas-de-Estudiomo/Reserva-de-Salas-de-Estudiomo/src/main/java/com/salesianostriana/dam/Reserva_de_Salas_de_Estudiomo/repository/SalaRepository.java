package com.salesianostriana.dam.Reserva_de_Salas_de_Estudiomo.repository;

import com.salesianostriana.dam.Reserva_de_Salas_de_Estudiomo.model.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaRepository extends JpaRepository<Sala,Long>, JpaSpecificationExecutor<Sala> {
}
