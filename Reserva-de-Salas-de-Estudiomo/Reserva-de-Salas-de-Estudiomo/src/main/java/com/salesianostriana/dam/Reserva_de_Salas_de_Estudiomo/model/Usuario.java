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
public class Usuario {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String nombre;
    private String email;
    private boolean baneado;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "usuario")
    private List<Reserva> reservaList;
}
