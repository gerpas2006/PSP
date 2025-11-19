package com.salesianostriana.dam.api_biblioteca.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GestionBiblioteca {

    @Id
    @GeneratedValue
    private Long id;
    private String nombreCiudad;
    private String nombreBiblioteca;
    private LocalDate anioFundacion;
    private int numLibros;
    private String descripcionGeneral;
    private String url;
}
