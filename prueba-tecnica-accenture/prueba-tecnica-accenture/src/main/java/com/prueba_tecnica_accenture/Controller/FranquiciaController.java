package com.prueba_tecnica_accenture.Controller;

import com.prueba_tecnica_accenture.Model.DTORequest.DtoFranquicia;
import com.prueba_tecnica_accenture.Service.FranquiciaService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/franquicia")
public class FranquiciaController {

private final FranquiciaService franquiciaService;

    @Operation(
            summary = "Agregar franquicia",
            description = "Permite agregar una franquicia."
    )
    @PostMapping("/agregar")
    public ResponseEntity<DtoFranquicia> crearFranquicia(@RequestBody @Valid DtoFranquicia dtoFranquicia) {
         DtoFranquicia dtoFranquiciaRespuesta  = franquiciaService.AgregarFranquicia(dtoFranquicia);
        return ResponseEntity.ok().body(dtoFranquiciaRespuesta);

    }
    @Operation(
            summary = "actualizar nombre de  franquicia",
            description = "Permite actualizar el nombre de una franquicia."
    )
    @PutMapping("/actualiar/nombre/{idFranquicia}")
    public ResponseEntity<DtoFranquicia> actualizarNombreFranquicia(@RequestBody @Valid DtoFranquicia dtoFranquicia, @PathVariable Long idFranquicia) {
        DtoFranquicia dtoFranquiciaRespuesta = franquiciaService.actualiarNombreFranquicia(dtoFranquicia, idFranquicia);
        return ResponseEntity.ok().body(dtoFranquiciaRespuesta);

    }
}
