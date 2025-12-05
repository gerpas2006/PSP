package com.salesianostriana.edu.pokemon.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.java.Log;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pokemon {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String nombrePokemon;
    private LocalDate diaDeCreacion;
    private String descripcionPokemon;



    @ManyToOne
    @JoinColumn(name = "tipo_id")
    private TipoPokemon tipoPokemon;

}
