package com.prueba_tecnica_accenture.Model.DTOResponse;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DtoGetMayorStockBySucursal {

    private String sucursal;
    private String nombreProducto;
    private int stock;


}
