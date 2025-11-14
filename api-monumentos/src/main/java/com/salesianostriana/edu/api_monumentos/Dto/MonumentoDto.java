package com.salesianostriana.edu.api_monumentos.Dto;

import com.salesianostriana.edu.api_monumentos.Model.Monumento;
import lombok.Builder;


import com.salesianostriana.edu.api_monumentos.Model.Monumento;

@Builder
public record MonumentoDto(
                           String codigoPais,
                           String nombrePais,
                           String nombreCiudad,
                           double latitud,
                           double longitud,
                           String localizacion,
                           String nombreMonumento,
                           String descripcionMonumento,
                           String fotoUrl) {


    public static MonumentoDto obtenerMonument (Monumento m){
        return MonumentoDto.builder()
                .codigoPais(m.getCodigoPais())
                .nombrePais(m.getNombrePais())
                .nombreCiudad(m.getNombreCiudad())
                .latitud(m.getLatitud())
                .longitud(m.getLongitud())
                .localizacion(m.getLocalizacion())
                .nombreMonumento(m.getNombreMonumento())
                .descripcionMonumento(m.getDescripcionMonumento())
                .fotoUrl(m.getFotoUrl()).build();
    }
}
