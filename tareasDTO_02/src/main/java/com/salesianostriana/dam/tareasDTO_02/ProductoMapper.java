package com.salesianostriana.dam.tareasDTO_02;


import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductoMapper {


    @Mapping(source = "nombre", target = "nombre")
    ProductoDTO toDTO(Producto producto);

    @InheritInverseConfiguration
    Producto toEntity(ProductoDTO dto);
}
