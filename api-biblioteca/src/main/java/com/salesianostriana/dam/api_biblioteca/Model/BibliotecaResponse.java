package com.salesianostriana.dam.api_biblioteca.Model;

import java.time.LocalDate;

public record BibliotecaResponse(
        Long id,
        String nombreCiudad,
        String nombreBiblioteca,
        LocalDate anioFundacion,
        int numLibros,
        String descripcionGeneral,
        String url
) {

    public static BibliotecaResponse of(GestionBiblioteca gestionBiblioteca){
        return new BibliotecaResponse(
                gestionBiblioteca.getId(),
                gestionBiblioteca.getNombreCiudad(),
                gestionBiblioteca.getNombreBiblioteca(),
                gestionBiblioteca.getAnioFundacion(),
                gestionBiblioteca.getNumLibros(),
                gestionBiblioteca.getDescripcionGeneral(),
                gestionBiblioteca.getUrl()
        );
    }
}
