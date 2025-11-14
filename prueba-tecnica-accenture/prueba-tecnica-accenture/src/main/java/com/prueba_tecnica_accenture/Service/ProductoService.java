package com.prueba_tecnica_accenture.Service;

import com.prueba_tecnica_accenture.Model.DTORequest.DtoProducto;
import com.prueba_tecnica_accenture.Model.DTORequest.DtoUpdateProductoStock;
import com.prueba_tecnica_accenture.Model.DTOResponse.DtoGetMayorStockBySucursal;

import java.util.List;

public interface ProductoService {

    DtoProducto AgregarProducto(DtoProducto dtoProducto);
    void EliminarProducto(Long id);
    void DesactivarProducto(Long id);
    DtoUpdateProductoStock UpdateStock(DtoUpdateProductoStock dtoUpdateProductoStock, Long id);
    List<DtoGetMayorStockBySucursal> getProductoMayorStockBySucursal(Long FranquiciaId);
    DtoProducto actualiarNombreProducto(DtoProducto dto, Long idProducto);
}
