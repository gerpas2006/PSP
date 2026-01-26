package com.salesianostriana.dam.Reserva_de_Salas_de_Estudiomo.repository;

import com.salesianostriana.dam.Reserva_de_Salas_de_Estudiomo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
