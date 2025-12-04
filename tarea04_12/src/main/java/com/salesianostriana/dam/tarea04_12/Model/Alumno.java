package com.salesianostriana.dam.tarea04_12.Model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Alumno {

    @GeneratedValue
    @Id
    private Long id;

    private String nombreAlumno;
    private int edad;

    @ManyToOne
    @JoinColumn(name = "clase_id")
    private Clase clase;
}
