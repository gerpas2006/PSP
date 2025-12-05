package com.salesianostriana.edu.pokemon.Model;

import jakarta.persistence.*;
import lombok.*;

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

    @Column(name = "nombrePokemon", nullable = true, length = 150)
    private String nombrePokemon;

    @Column(name = "descripcionPokemon", nullable = false, length = 255)
    private String descripcionPokemon;

    @Enumerated(EnumType.STRING)
    private TipoAtaque tipoAtaque;

    @Enumerated(EnumType.STRING)
    private TipoPokemon tipoPokemon;

    @ManyToOne
    @JoinColumn(name = "entrenador_id")
    private Entrenador entrenador;

}
