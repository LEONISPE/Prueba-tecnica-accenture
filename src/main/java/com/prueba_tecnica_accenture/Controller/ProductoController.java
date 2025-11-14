package com.prueba_tecnica_accenture.Controller;

import com.prueba_tecnica_accenture.Model.DTORequest.DtoProducto;
import com.prueba_tecnica_accenture.Model.DTORequest.DtoSucursal;
import com.prueba_tecnica_accenture.Model.DTORequest.DtoUpdateProductoStock;
import com.prueba_tecnica_accenture.Model.DTOResponse.DtoGetMayorStockBySucursal;
import com.prueba_tecnica_accenture.Service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/producto")
public class ProductoController {


    private  final ProductoService productoService;

    @Operation(
            summary = "Agregar producto",
            description = "Permite agregar  productos."
    )
    @PostMapping("/agregar")
    public ResponseEntity<DtoProducto> crearProducto(@RequestBody @Valid DtoProducto dtoProducto) {
        DtoProducto dtoProductoRespuesta  = productoService.AgregarProducto(dtoProducto);
        return ResponseEntity.ok().body(dtoProductoRespuesta);

    }

    @Operation(
            summary = "Eliminar producto",
            description = "Permite Eliminar  productos."
    )
    @DeleteMapping("/eliminar")
    public ResponseEntity<String> EliminarProducto(@PathVariable Long id) {
      productoService.EliminarProducto(id);
        return ResponseEntity.ok(" Producto Eliminado");

    }

    @Operation(
            summary = "Desactivar producto",
            description = "Permite Desactivar  productos."
    )
    @DeleteMapping("/desactivar")
    public ResponseEntity<String> DesactivarProducto(@PathVariable Long id) {
        productoService.DesactivarProducto(id);
        return ResponseEntity.ok(" Producto Desactivado");

    }
    @Operation(
            summary = "Actualizar producto",
            description = "Permite actualizar stock de   productos."
    )
    @PutMapping("/actualizar/stock/{id}")
    public ResponseEntity<DtoUpdateProductoStock> ActualizarProducto(@RequestBody DtoUpdateProductoStock dtoUpdateProductoStock ,@PathVariable Long id ) {
        DtoUpdateProductoStock dtoUpdateProductoStock1 = productoService.UpdateStock(dtoUpdateProductoStock,id);
        return ResponseEntity.ok().body(dtoUpdateProductoStock1);

    }
    @Operation(
            summary = "ver producto con mayor stock by sucursal",
            description = "Permite obtner los productos con mayor stock por sucursal por una franquicia."
    )
    @PutMapping("/maxStock/{FranquiciaId}")
    public ResponseEntity<List<DtoGetMayorStockBySucursal>> GetMaxStockProductoBySucursal(@PathVariable Long FranquiciaId  ) {
       List<DtoGetMayorStockBySucursal> resultado = productoService.getProductoMayorStockBySucursal(FranquiciaId);
        return ResponseEntity.ok().body(resultado);

    }


    @PutMapping("/actualiar/nombre/{idproducto}")
    public ResponseEntity<DtoProducto> actualizarNombreProducto(@RequestBody @Valid DtoProducto dtoProducto, @PathVariable Long idproducto) {
        DtoProducto dtoProducto1 = productoService.actualiarNombreProducto(dtoProducto,idproducto);
        return ResponseEntity.ok().body(dtoProducto1);

    }

}
