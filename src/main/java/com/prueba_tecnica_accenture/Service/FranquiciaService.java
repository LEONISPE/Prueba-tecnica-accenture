package com.prueba_tecnica_accenture.Service;

import com.prueba_tecnica_accenture.Model.DTORequest.DtoFranquicia;

public interface FranquiciaService {

   DtoFranquicia AgregarFranquicia(DtoFranquicia dtoFranquicia);
   DtoFranquicia actualiarNombreFranquicia(DtoFranquicia dto, Long idFranquicia);

}
