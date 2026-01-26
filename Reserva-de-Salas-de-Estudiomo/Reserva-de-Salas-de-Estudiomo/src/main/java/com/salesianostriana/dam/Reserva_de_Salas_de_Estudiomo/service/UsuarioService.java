package com.salesianostriana.dam.Reserva_de_Salas_de_Estudiomo.service;

import com.salesianostriana.dam.Reserva_de_Salas_de_Estudiomo.model.Usuario;
import com.salesianostriana.dam.Reserva_de_Salas_de_Estudiomo.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

}
