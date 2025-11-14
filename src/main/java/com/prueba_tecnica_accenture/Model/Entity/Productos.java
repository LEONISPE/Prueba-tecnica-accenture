package com.prueba_tecnica_accenture.Model.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Table( name = "producto")
@Entity
public class Productos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sucursal_id")
    @JsonBackReference
    private Sucursales sucursal;

    private Boolean activo = true;

    private int stock;


    public void desactivarProducto() {
        this.activo = false;
    }
}
