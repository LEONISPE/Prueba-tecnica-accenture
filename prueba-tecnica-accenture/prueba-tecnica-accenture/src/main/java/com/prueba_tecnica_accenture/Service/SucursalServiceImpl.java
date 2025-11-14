package com.prueba_tecnica_accenture.Service;
import com.prueba_tecnica_accenture.Model.DTORequest.DtoSucursal;
import com.prueba_tecnica_accenture.Model.Entity.Franquicias;
import com.prueba_tecnica_accenture.Model.Entity.Sucursales;
import com.prueba_tecnica_accenture.Model.Mapper.AgregarSucursalMapper;
import com.prueba_tecnica_accenture.Repository.FranquiciaRepository;
import com.prueba_tecnica_accenture.Repository.SucursalRepository;
import com.prueba_tecnica_accenture.exceptions.ValidationException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class SucursalServiceImpl implements SucursalService {

    private SucursalRepository sucursalRepository;
    private FranquiciaRepository franquiciaRepository;
    private AgregarSucursalMapper agregarSucursalMapper;


    @Override
    public DtoSucursal agregarSucursal(DtoSucursal dtoagregarsucursal) {
        Optional<Franquicias> franquiciaOptional = franquiciaRepository.findById(dtoagregarsucursal.getIdFranquicia());

        if (!franquiciaOptional.isPresent()) {
            throw new ValidationException("El id de la franquicia no existe");
        }


        Franquicias franquiciaExistente = franquiciaOptional.get();


        Sucursales sucursales = agregarSucursalMapper.toEntity(dtoagregarsucursal);


        sucursales.setFranquicia(franquiciaExistente);


        sucursalRepository.save(sucursales);
        return dtoagregarsucursal;

    }

    @Override
    public DtoSucursal actualiarNombreSucursal(DtoSucursal dto, Long idSucursal) {
        Sucursales sucursales = sucursalRepository.findById(idSucursal).get();
        if(!sucursalRepository.findById(idSucursal).isPresent()){
            throw new ValidationException("la sucursal no existe");
        }
        sucursales.setNombre(dto.getNombre());
        sucursalRepository.save(sucursales);
        return dto;
    }




}
