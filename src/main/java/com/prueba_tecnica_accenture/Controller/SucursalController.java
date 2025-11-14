package com.prueba_tecnica_accenture.Controller;

import com.prueba_tecnica_accenture.Model.DTORequest.DtoFranquicia;
import com.prueba_tecnica_accenture.Model.DTORequest.DtoSucursal;
import com.prueba_tecnica_accenture.Service.SucursalService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/sucursal")
public class SucursalController {

    private final SucursalService sucursalService;

    @Operation(
            summary = "Agregar sucursal",
            description = "Permite agregar una sucursal."
    )
    @PostMapping("/agregar")
    public ResponseEntity<DtoSucursal> crearSucursal(@RequestBody @Valid DtoSucursal dtoSucursal) {
        DtoSucursal dtoSucursalRespuesta  = sucursalService.agregarSucursal(dtoSucursal);
        return ResponseEntity.ok().body(dtoSucursalRespuesta);

    }
    @PutMapping("/actualiar/nombre/{idSucursal}")
    public ResponseEntity<DtoSucursal> actualizarNombreSucursal(@RequestBody @Valid DtoSucursal dtoSucursal, @PathVariable Long idSucursal) {
        DtoSucursal dtoSucursal1Respuesta = sucursalService.actualiarNombreSucursal(dtoSucursal, idSucursal);
        return ResponseEntity.ok().body(dtoSucursal1Respuesta);

    }
}
