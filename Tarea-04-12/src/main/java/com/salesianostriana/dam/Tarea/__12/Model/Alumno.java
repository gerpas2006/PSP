package com.salesianostriana.dam.Tarea.__12.Model;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Alumno {

    private String nombre;
    private int edad;
}
