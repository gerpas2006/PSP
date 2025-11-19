package com.salesianostriana.dam.api_biblioteca.Error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;

@RestControllerAdvice
public class GlobalErrorController extends  BibliotecaNotFoundException{

    @ExceptionHandler(BibliotecaNotFoundException.class)
    public ProblemDetail handleBibliotecaNotFound(
            BibliotecaNotFoundException ex
    ){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.NOT_FOUND, ex.getMessage()
        );

        problemDetail.setTitle("Biblioteca no encontrada");
        problemDetail.setType(
                URI.create("http://dam.salesianos-triana.com/monumento-not-found"));

        return problemDetail;
    }


    @ExceptionHandler(IllegalAccessError.class)
    public ProblemDetail handleBadMonument(IllegalAccessError ex){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,
                ex.getMessage());
        return problemDetail;
    }


}
