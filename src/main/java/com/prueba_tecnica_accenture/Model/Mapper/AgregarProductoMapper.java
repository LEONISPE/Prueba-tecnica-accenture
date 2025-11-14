package com.prueba_tecnica_accenture.Model.Mapper;

import com.prueba_tecnica_accenture.Model.DTORequest.DtoProducto;
import com.prueba_tecnica_accenture.Model.Entity.Productos;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AgregarProductoMapper {

    Productos toEntity(DtoProducto dtoProducto);
}
