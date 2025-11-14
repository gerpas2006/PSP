package com.salesianostriana.edu.api_monumentos.Controller;


import com.salesianostriana.edu.api_monumentos.Dto.MonumentoDto;
import com.salesianostriana.edu.api_monumentos.Model.Monumento;
import com.salesianostriana.edu.api_monumentos.Service.MonumetoService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monument/")
@RequiredArgsConstructor
public class MonumentoController {

    private final MonumetoService monumetoService;

    @GetMapping
    public List<Monumento> getAll(){
        return monumetoService.findAll();
    }

    @GetMapping("/{id}")
    public Monumento getById(@PathVariable Long id){
        return  monumetoService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Monumento> create(@RequestBody MonumentoDto monumentoDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(monumetoService.save(monumentoDto));
    }

    @PutMapping("/{id}")
    public Monumento edit(@RequestBody MonumentoDto monumentoDto,@PathVariable Long id){
        return monumetoService.edit(monumentoDto,id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        monumetoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
