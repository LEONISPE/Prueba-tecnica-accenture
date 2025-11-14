package com.prueba_tecnica_accenture.Repository;

import com.prueba_tecnica_accenture.Model.Entity.Sucursales;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SucursalRepository extends JpaRepository<Sucursales, Long> {

    List<Sucursales> findBySucursal(Long sucursalId);

}
