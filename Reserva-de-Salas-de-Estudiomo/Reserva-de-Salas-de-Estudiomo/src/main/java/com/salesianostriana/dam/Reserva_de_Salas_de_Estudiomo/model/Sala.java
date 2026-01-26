package com.salesianostriana.dam.Reserva_de_Salas_de_Estudiomo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Sala {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String nombre;
    private Integer planta;
    private Integer capacidad;
    private boolean disponible;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "sala")
    private List<Reserva> reservaList;

}
