package com.salesianostriana.edu.api_monumentos.Repository;

import com.salesianostriana.edu.api_monumentos.Model.Monumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonumentoRepository extends JpaRepository<Monumento,Long> {
}
