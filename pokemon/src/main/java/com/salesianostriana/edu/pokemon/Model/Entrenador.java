package com.salesianostriana.edu.pokemon.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Entrenador {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "nombreEntrenador", nullable = true, length = 150)
    private String nombreEntrenador;

    private LocalDate fechaNacimiento;

    @OneToMany(mappedBy = "entrenador")
    private List<Pokemon> listaPokemon;



}
