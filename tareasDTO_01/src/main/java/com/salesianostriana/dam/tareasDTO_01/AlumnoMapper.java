package com.salesianostriana.dam.tareasDTO_01;


import lombok.experimental.UtilityClass;

@UtilityClass
public class AlumnoMapper {

    public AlumnosDTO toDto (Alumno alumno){
        if (alumno == null) return null;

        return new AlumnosDTO(
                alumno.getId(),
                alumno.getNombre(),
                alumno.getApellido1(),
                alumno.getApellido2(),
                alumno.getTelefono(),
                alumno.getEmail(),
                alumno.getDirecccion(),
                alumno.getCurso()
        );
    }

    public Alumno toEntity(AlumnosDTO dto){
        if(dto == null) return null;
        return Alumno.builder()
                .id(dto.id())
                .nombre(dto.nombre())
                .apellido1(dto.apellido1())
                .apellido2(dto.apellido2())
                .telefono(dto.telefono())
                .email(dto.email())
                .direcccion(dto.direccion())
                .curso(dto.curso())
                .build();
    }

}
