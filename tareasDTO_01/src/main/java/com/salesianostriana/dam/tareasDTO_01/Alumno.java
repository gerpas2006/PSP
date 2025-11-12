package com.salesianostriana.dam.tareasDTO_01;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Alumno {

    private Long id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private Long telefono;
    private String email;
    private Direccion direcccion;
    private Curso curso;




}
