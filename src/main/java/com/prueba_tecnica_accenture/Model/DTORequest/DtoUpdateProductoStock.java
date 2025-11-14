package com.prueba_tecnica_accenture.Model.DTORequest;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoUpdateProductoStock {

    @NotNull(message = "el stock no puede ser nulo")
    @Min(1)
    private int stock;
}
