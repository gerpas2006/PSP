package com.salesianostriana.edu.api_monumentos.Service;

import com.salesianostriana.edu.api_monumentos.Dto.MonumentoDto;
import com.salesianostriana.edu.api_monumentos.Error.MonumentoException;
import com.salesianostriana.edu.api_monumentos.Model.Monumento;
import com.salesianostriana.edu.api_monumentos.Repository.MonumentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MonumetoService {

    private final MonumentoRepository monumentoRepository;


    public List<Monumento> findAll(){
        List<Monumento> listarMonumento = monumentoRepository.findAll();
        if(listarMonumento.isEmpty())
            throw new MonumentoException();
        return listarMonumento;
    }

    public Monumento findById (Long id){
        return monumentoRepository.findById(id)
                .orElseThrow(() -> new MonumentoException(id));
    }

    public Monumento save(MonumentoDto monumento){
        return monumentoRepository.save(
                Monumento.builder()
                        .codigoPais(monumento.codigoPais())
                        .nombreCiudad(monumento.nombreCiudad())
                        .latitud(monumento.latitud())
                        .longitud(monumento.longitud())
                        .localizacion(monumento.localizacion())
                        .nombreMonumento(monumento.nombreMonumento())
                        .descripcionMonumento(monumento.descripcionMonumento())
                        .fotoUrl(monumento.fotoUrl())
                        .build());
    }


public Monumento edit(MonumentoDto monumentoDto,Long id) {
    Monumento monumento = Monumento.builder()
            .id(id)
            .codigoPais(monumentoDto.codigoPais())
            .nombreCiudad(monumentoDto.nombreCiudad())
            .latitud(monumentoDto.latitud())
            .longitud(monumentoDto.longitud())
            .localizacion(monumentoDto.localizacion())
            .nombreMonumento(monumentoDto.nombreMonumento())
            .descripcionMonumento(monumentoDto.descripcionMonumento())
            .fotoUrl(monumentoDto.fotoUrl())
            .build();
    return monumentoRepository.save(monumento);
}

public void delete(Long id){
        monumentoRepository.deleteById(id);
}
}