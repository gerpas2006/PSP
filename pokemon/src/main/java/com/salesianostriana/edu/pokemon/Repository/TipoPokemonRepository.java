package com.salesianostriana.edu.pokemon.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPokemonRepository extends JpaRepository<TipoPokemon,Long> {
}
