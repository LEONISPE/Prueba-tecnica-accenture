package com.prueba_tecnica_accenture.Service;

import com.prueba_tecnica_accenture.Model.DTORequest.DtoProducto;
import com.prueba_tecnica_accenture.Model.DTORequest.DtoSucursal;
import com.prueba_tecnica_accenture.Model.DTORequest.DtoUpdateProductoStock;
import com.prueba_tecnica_accenture.Model.DTOResponse.DtoGetMayorStockBySucursal;
import com.prueba_tecnica_accenture.Model.Entity.Franquicias;
import com.prueba_tecnica_accenture.Model.Entity.Productos;
import com.prueba_tecnica_accenture.Model.Entity.Sucursales;
import com.prueba_tecnica_accenture.Model.Mapper.AgregarProductoMapper;
import com.prueba_tecnica_accenture.Repository.FranquiciaRepository;
import com.prueba_tecnica_accenture.Repository.ProductoRepository;
import com.prueba_tecnica_accenture.Repository.SucursalRepository;
import com.prueba_tecnica_accenture.exceptions.ValidationException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private ProductoRepository productoRepository;
    private SucursalRepository sucursalRepository;
    private AgregarProductoMapper agregarProductoMapper;
    private FranquiciaRepository franquiciaRepository;

    @Override
    public DtoProducto AgregarProducto(DtoProducto dtoProducto) {

        Optional<Sucursales> SucursalesOptional = sucursalRepository.findById(dtoProducto.getIdSucursal());
        if (!SucursalesOptional.isPresent()) {
            throw new ValidationException("El id de la sucursal no existe");
        }


        Sucursales SucursalExistente = SucursalesOptional.get();


         Productos productos = agregarProductoMapper.toEntity(dtoProducto);


        productos.setSucursal(SucursalExistente);


        productoRepository.save(productos);
        return dtoProducto;

    }



    @Override
    public void EliminarProducto(Long id) {
        if(!productoRepository.findById(id).isPresent()){
            throw new ValidationException("el producto no existe");
        }
        productoRepository.deleteById(id);
    }

    @Override
    public void DesactivarProducto(Long id) {
        Productos producto = productoRepository.findById(id).get();

        if(!productoRepository.findById(id).isPresent()){
            throw new ValidationException("el producto no existe");
        }
       producto.desactivarProducto();
        productoRepository.save(producto);
    }

    @Override
    public DtoUpdateProductoStock UpdateStock(DtoUpdateProductoStock dtoUpdateProductoStock, Long id) {
        Productos producto = productoRepository.findById(id).get();
        if(!productoRepository.findById(id).isPresent()){
            throw new ValidationException("el producto no existe");
        }
        producto.setStock(dtoUpdateProductoStock.getStock());
        productoRepository.save(producto);
        return dtoUpdateProductoStock;

    }

    @Override
    public List<DtoGetMayorStockBySucursal> getProductoMayorStockBySucursal(Long FranquiciaId) {

        franquiciaRepository.findById(FranquiciaId)
                .orElseThrow(() -> new ValidationException("la franquicia no existe"));

        List<Sucursales> sucursales = sucursalRepository.findBySucursal(FranquiciaId);

        List<DtoGetMayorStockBySucursal> response = new ArrayList<>();
        for (Sucursales sucursales1 : sucursales) {

            List<Productos> productos = productoRepository.findByIdSucursal(sucursales1.getId());

            if (productos.isEmpty()) continue;


            Productos mayorProductoStock = productos.stream()
                    .max(Comparator.comparing(Productos::getStock))
                    .orElse(null);


            if (mayorProductoStock != null) {
                response.add(
                        new DtoGetMayorStockBySucursal(
                                sucursales1.getNombre(),
                                mayorProductoStock.getNombre(),
                                mayorProductoStock.getStock())
                );
            }
        }

        return response;



    }
    @Override
    public DtoProducto actualiarNombreProducto(DtoProducto dto, Long idProducto) {
        Productos productos = productoRepository.findById(idProducto).get();
        if(!productoRepository.findById(idProducto).isPresent()){
            throw new ValidationException("el producto no existe");
        }
        productos.setNombre(dto.getNombre());
        productoRepository.save(productos);
        return dto;
    }

}
