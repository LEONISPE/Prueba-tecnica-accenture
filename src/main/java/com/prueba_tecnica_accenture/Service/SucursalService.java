package com.prueba_tecnica_accenture.Service;

import com.prueba_tecnica_accenture.Model.DTORequest.DtoSucursal;

public interface SucursalService {

    DtoSucursal agregarSucursal(DtoSucursal dtoagregarsucursal);
    DtoSucursal actualiarNombreSucursal(DtoSucursal dto, Long idSucursal);
}
