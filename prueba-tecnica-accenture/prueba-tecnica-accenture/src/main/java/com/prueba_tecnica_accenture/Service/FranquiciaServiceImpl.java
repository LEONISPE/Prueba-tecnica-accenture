package com.prueba_tecnica_accenture.Service;

import com.prueba_tecnica_accenture.Model.AgregarFranquiciaMapper;
import com.prueba_tecnica_accenture.Model.DTORequest.DtoFranquicia;
import com.prueba_tecnica_accenture.Model.Entity.Franquicias;
import com.prueba_tecnica_accenture.Repository.FranquiciaRepository;
import com.prueba_tecnica_accenture.exceptions.ValidationException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FranquiciaServiceImpl implements FranquiciaService {

    private FranquiciaRepository franquiciaRepository;
    private AgregarFranquiciaMapper agregarFranquiciaMapper;


    @Override
    public DtoFranquicia AgregarFranquicia(DtoFranquicia dtoFranquicia) {
        if(dtoFranquicia.getNombre() == null){
        throw  new ValidationException("El nombre no puede ser nulo");
        }
        Franquicias franquicias = agregarFranquiciaMapper.toEntity(dtoFranquicia);
        franquiciaRepository.save(franquicias);
        return dtoFranquicia;

    }

    @Override
    public DtoFranquicia actualiarNombreFranquicia(DtoFranquicia dto, Long idFranquicia) {
        Franquicias franquicias = franquiciaRepository.findById(idFranquicia).get();
        if(!franquiciaRepository.findById(idFranquicia).isPresent()){
            throw new ValidationException("la franquicia no existe");
        }
        franquicias.setNombre(dto.getNombre());
        franquiciaRepository.save(franquicias);
        return dto;
    }


}
