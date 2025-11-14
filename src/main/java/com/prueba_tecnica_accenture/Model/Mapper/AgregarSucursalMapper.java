package com.prueba_tecnica_accenture.Model.Mapper;

import com.prueba_tecnica_accenture.Model.DTORequest.DtoSucursal;
import com.prueba_tecnica_accenture.Model.Entity.Sucursales;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AgregarSucursalMapper {

    Sucursales toEntity(DtoSucursal dtoSucursal);

}
