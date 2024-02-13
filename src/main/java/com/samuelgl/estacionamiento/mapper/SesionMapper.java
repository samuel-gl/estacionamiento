package com.samuelgl.estacionamiento.mapper;

import com.samuelgl.estacionamiento.DTO.SesionDTO;
import com.samuelgl.estacionamiento.entidad.Sesion;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SesionMapper {

    public Sesion toEntity(SesionDTO DTO);
    public SesionDTO toDTO(Sesion entity);

}