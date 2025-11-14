package com.salesianostriana.edu.api_monumentos.Error;

public class MonumentoException extends RuntimeException {
    public MonumentoException(String message) {
        super(message);
    }

    public MonumentoException(Long id){
        super("No hay un monumeto con ese ID: %d".formatted(id));
    }

    public MonumentoException(){
        super("No hay monumentos con esos requisitos de bsuqueda");
    }


}
