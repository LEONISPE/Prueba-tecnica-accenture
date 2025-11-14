package com.prueba_tecnica_accenture.Model;


import com.prueba_tecnica_accenture.Model.DTORequest.DtoFranquicia;
import com.prueba_tecnica_accenture.Model.Entity.Franquicias;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface AgregarFranquiciaMapper {

   Franquicias toEntity(DtoFranquicia dtoFranquicia);
}
