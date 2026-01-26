package com.salesianostriana.dam.Reserva_de_Salas_de_Estudiomo.repository;

import com.salesianostriana.dam.Reserva_de_Salas_de_Estudiomo.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva,Long> {
}
