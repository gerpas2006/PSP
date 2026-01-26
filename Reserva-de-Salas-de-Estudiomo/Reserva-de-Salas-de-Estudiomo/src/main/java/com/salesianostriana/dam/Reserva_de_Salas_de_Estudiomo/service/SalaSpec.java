package com.salesianostriana.dam.Reserva_de_Salas_de_Estudiomo.service;


import com.salesianostriana.dam.Reserva_de_Salas_de_Estudiomo.model.Sala;
import org.springframework.data.jpa.domain.PredicateSpecification;

import java.time.LocalDate;
import java.time.LocalTime;

public interface SalaSpec {

    static PredicateSpecification<Sala> filtarPorPlanta(Integer planta){
        return (from, criteriaBuilder) ->
                planta == null ? criteriaBuilder.and() :criteriaBuilder.equal(from.get("planta"),planta);
    }

    static PredicateSpecification<Sala> filtarPorCapacida(Integer capMax,Integer capMin){
        Integer capMaxReal = capMax == null ? 0 : capMax;
        Integer capMinReal = capMin == null ? 0 : capMin;
        return (from, criteriaBuilder) ->
                criteriaBuilder.between(from.get("capacidad"),capMax,capMin);
    }

    static PredicateSpecification<Sala> filtrarPorNombre(String nombre){
        return (from, criteriaBuilder) ->
                nombre == null ? criteriaBuilder.and() : criteriaBuilder.like(from.get("nombre"),nombre);
    }

    static PredicateSpecification<Sala> filtraPorDisponible(){
        return (from, criteriaBuilder) ->
                criteriaBuilder.isTrue(from.get("disponible"));
    }

    static PredicateSpecification<Sala> filtarPorFecha(LocalDate fecha){
        return (from, criteriaBuilder) ->
                fecha == null ? criteriaBuilder.and() : criteriaBuilder.greaterThan(from.join("reservaList").get("fecha"),fecha);
    }

    static PredicateSpecification<Sala> filtrarPorHora(LocalTime horaInicio,LocalTime horaFin){
        LocalTime horaInicioReal = horaInicio == null ? LocalTime.now() : horaInicio;
        LocalTime horaFinReal = horaFin == null ? LocalTime.now() : horaFin;
        return  (from, criteriaBuilder) ->
                criteriaBuilder.between(from.join("reservaList").get("horaInicio").get("horaFin"),horaInicioReal,horaFinReal);
    }
}
