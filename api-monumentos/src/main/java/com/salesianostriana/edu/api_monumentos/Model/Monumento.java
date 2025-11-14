package com.salesianostriana.edu.api_monumentos.Model;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "monumento")
public class Monumento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigoPais;
    private String nombrePais;
    private String nombreCiudad;
    private double latitud;
    private double longitud;
    private String localizacion;
    private String nombreMonumento;

    private String descripcionMonumento;
    @Lob
    private String fotoUrl;
}
