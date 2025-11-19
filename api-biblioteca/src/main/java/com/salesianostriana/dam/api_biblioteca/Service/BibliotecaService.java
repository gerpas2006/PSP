package com.salesianostriana.dam.api_biblioteca.Service;

import ch.qos.logback.core.util.StringUtil;
import com.salesianostriana.dam.api_biblioteca.Error.BibliotecaNotFoundException;
import com.salesianostriana.dam.api_biblioteca.Model.CrearBibliotecaCmd;
import com.salesianostriana.dam.api_biblioteca.Model.GestionBiblioteca;
import com.salesianostriana.dam.api_biblioteca.Repository.BibliotecaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.BitSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BibliotecaService {

    private final BibliotecaRepository bibliotecaRepository;

    public List<GestionBiblioteca> getAll(){
        List<GestionBiblioteca> result = bibliotecaRepository.findAll();

        if (result.isEmpty())
            throw new BibliotecaNotFoundException("No hay bibliotecas registradas");
        return result;
    }


    public GestionBiblioteca getById(Long id){
        return bibliotecaRepository.findById(id)
                .orElseThrow(() -> new BibliotecaNotFoundException(id));
    }

    public GestionBiblioteca save(CrearBibliotecaCmd cmd){
        if (!StringUtils.hasText(cmd.nombreBiblioteca())){
            throw new IllegalArgumentException("Error al crear la biblioteca");
        }
        return bibliotecaRepository.save(cmd.toEntity());
    }


    public GestionBiblioteca edit (CrearBibliotecaCmd cmd, Long id){
        return bibliotecaRepository.findById(id)
                .map(gestionBiblioteca -> {
                    gestionBiblioteca.setNombreCiudad(cmd.nombreCiudad());
                    gestionBiblioteca.setNombreBiblioteca(cmd.nombreBiblioteca());
                    gestionBiblioteca.setAnioFundacion(cmd.anioFundacion());
                    gestionBiblioteca.setDescripcionGeneral(cmd.descripcionGeneral());
                    gestionBiblioteca.setUrl(cmd.url());
                    gestionBiblioteca.setNumLibros(cmd.numLibros());

                    return bibliotecaRepository.save(gestionBiblioteca);
                })
                .orElseThrow(() -> new RuntimeException());
    }


    public void deleteById(Long id){
        bibliotecaRepository.deleteById(id);
    }




}
