package com.salesianostriana.edu.api_monumentos.Controller;


import com.salesianostriana.edu.api_monumentos.Dto.MonumentoDto;
import com.salesianostriana.edu.api_monumentos.Error.MonumentoException;
import com.salesianostriana.edu.api_monumentos.Model.Monumento;
import com.salesianostriana.edu.api_monumentos.Service.MonumetoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monumento/")
@RequiredArgsConstructor
@Tag(name = "Monumento", description = "El controlador de monumentos, para poder realizar todas las operaciones de gestión")
public class MonumentoController {

    private final MonumetoService monumetoService;


    @GetMapping
    @Operation(summary = "Obtiene todos los monumentos",
            description = "Devuelve una lista de monumentos.")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Se han encontrado los monumentos",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = MonumentoDto.class)),
                            examples = @ExampleObject(
                                    value = """
                    [
                      {
                        "descripcion": "La Giralda de Sevilla es muy bonita porque yo he estado allí",
                        "pais": "España"
                      }
                    ]
                    """
                            )
                    )
            ),
            @ApiResponse(responseCode = "404", description = "No se ha encontrado el monumento")
    })
    public List<Monumento> getAll(){
        return monumetoService.findAll();
    }

    @GetMapping("/{id}")
    public Monumento getById(@PathVariable Long id){
        return  monumetoService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Crea un nuevo monumento")
    @ApiResponse(responseCode = "201", description = "Monumento creado  correctamente")
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
