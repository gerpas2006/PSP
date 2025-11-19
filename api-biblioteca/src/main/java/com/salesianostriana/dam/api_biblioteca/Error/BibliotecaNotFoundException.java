package com.salesianostriana.dam.api_biblioteca.Error;

public class BibliotecaNotFoundException extends RuntimeException{


    public BibliotecaNotFoundException (){
        super("Biblioteca no encontrada");
    }

    public BibliotecaNotFoundException(String message){
        super(message);
    }

    public BibliotecaNotFoundException(Long id){
        super("No se ha encontrado esa biblioteca con la id %d".formatted(id));
    }

}
