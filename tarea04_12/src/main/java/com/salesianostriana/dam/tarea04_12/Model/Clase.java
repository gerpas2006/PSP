package com.salesianostriana.dam.tarea04_12.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Clase {

    @GeneratedValue
    @Id
    private Long id;

    private String nombreClase;

    @OneToMany(mappedBy = "clase")
    private List<Alumno> listaAlumnos;
}
