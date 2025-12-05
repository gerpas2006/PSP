package com.salesianostriana.edu.pokemon.Model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoPokemon {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String tipoPokemon;

    @Enumerated(EnumType.STRING)
    private TipoAtaque tipoAtaque;

    @OneToMany(mappedBy = "tipoPokemon")
    private Pokemon pokemon;
}
