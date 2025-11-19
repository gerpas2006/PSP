package com.salesianostriana.dam.api_biblioteca.Repository;

import com.salesianostriana.dam.api_biblioteca.Model.GestionBiblioteca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BibliotecaRepository extends JpaRepository<GestionBiblioteca,Long> {
}
