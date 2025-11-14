package com.prueba_tecnica_accenture.Repository;

import com.prueba_tecnica_accenture.Model.Entity.Productos;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface ProductoRepository extends JpaRepository<Productos,Long> {

List<Productos> findByIdSucursal(Long sucursalId);
}
