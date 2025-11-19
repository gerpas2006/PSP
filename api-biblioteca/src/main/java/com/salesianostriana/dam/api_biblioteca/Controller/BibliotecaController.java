package com.salesianostriana.dam.api_biblioteca.Controller;


import com.salesianostriana.dam.api_biblioteca.Model.BibliotecaResponse;
import com.salesianostriana.dam.api_biblioteca.Model.CrearBibliotecaCmd;
import com.salesianostriana.dam.api_biblioteca.Model.GestionBiblioteca;
import com.salesianostriana.dam.api_biblioteca.Service.BibliotecaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/biblioteca/")
@RequiredArgsConstructor
@Tag(name = "Biblioteca", description = "El controlador de bibliotecas, para  poder realizar todas las operaciones de gestion")
public class BibliotecaController {

    private final BibliotecaService servicio;




    @GetMapping
    @Operation(summary = "Endpoint para obtener las bibliotecas registradas")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Se han encontrado bibliotecas",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = BibliotecaResponse.class)),
                            examples = @ExampleObject(value = """
                                    [
                                     {
                                         "Nombre Ciudad": "Sevilla",
                                         "Anio Fundacion": "17/09/2005"
                                     }
                                    ]
                                    """)
                    )
            )
    })
    public List<BibliotecaResponse> getAll(){
        return servicio.getAll().stream()
                .map(BibliotecaResponse::of)
                .toList();
    }

    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Biblioteca encontrada",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = BibliotecaResponse.class)
                            )

                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "No se ha encontrado la biblioteca",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ProblemDetail.class),
                                    examples = @ExampleObject(
                                            value = """
                                                        {
                                                        "type": "http://dam.salesianos-triana.com/monumento-not-found",
                                                        "title": "Biblioteca no encontrada",
                                                        "status": "404",
                                                        "detail": "No se ha encontrado la biblioteca con id 1"
                                                        "instance": "/biblioteca/1
                                                    
                                                        }
                                                    """
                                    )
                            )
                    )
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<BibliotecaResponse> getById(@PathVariable Long id){
        return ResponseEntity.ok(
                BibliotecaResponse.of(servicio.getById(id))
        );
    }

    @PostMapping
    public ResponseEntity<BibliotecaResponse> create(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos necesarios para crear una biblioteca",
                    required = true,
                    content = @Content(
                            schema = @Schema(implementation = CrearBibliotecaCmd.class),
                            examples = @ExampleObject(
                                    value = """
                                        {
                                            "Nombre Ciudad": "Sevilla",
                                            "anio Fundacion": "16/09/2005"
                                        }
                                        """
                            )
                    )
            )
            @RequestBody CrearBibliotecaCmd cmd
    ) {
        GestionBiblioteca nuevo = servicio.save(cmd);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(BibliotecaResponse.of(nuevo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BibliotecaResponse> edit(
            @PathVariable Long id,
            @RequestBody CrearBibliotecaCmd cmd){
        return ResponseEntity.ok(
                BibliotecaResponse.of(
                        servicio.edit(cmd,id)
                ));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        servicio.deleteById(id);
        return ResponseEntity.noContent().build();
    }



}
