package com.prueba_tecnica_accenture.Model.DTORequest;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DtoFranquicia {

    @NotBlank(message = "el nombre de la Franquicia es obligatorio")
    private String nombre;

}
