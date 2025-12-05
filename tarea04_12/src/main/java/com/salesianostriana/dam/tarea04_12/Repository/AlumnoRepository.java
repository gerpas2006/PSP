package com.salesianostriana.dam.tarea04_12.Repository;

import com.salesianostriana.dam.tarea04_12.Model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno,Long> {
}
