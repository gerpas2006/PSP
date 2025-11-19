package com.salesianostriana.dam.api_biblioteca.Model;

import java.time.LocalDate;

public record CrearBibliotecaCmd(
        String nombreCiudad,
        String nombreBiblioteca,
        LocalDate anioFundacion,
        int numLibros,
        String descripcionGeneral,
        String url
) {

    public GestionBiblioteca toEntity(){
        return  GestionBiblioteca.builder()
                .nombreCiudad(this.nombreCiudad)
                .nombreBiblioteca(this.nombreBiblioteca)
                .anioFundacion(this.anioFundacion)
                .numLibros(this.numLibros)
                .descripcionGeneral(this.descripcionGeneral)
                .url(this.url)
                .build();
    }
}
