package com.samuelgl.estacionamiento.mapper;

import com.samuelgl.estacionamiento.DTO.EstacionamientoDTO;
import com.samuelgl.estacionamiento.DTO.SesionDTO;
import com.samuelgl.estacionamiento.entidad.Estacionamiento;
import com.samuelgl.estacionamiento.entidad.Sesion;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EstacionamientoMapper {

    public Estacionamiento toEnitity(EstacionamientoDTO DTO);
    public EstacionamientoDTO toDTO(Estacionamiento entity);

    public List<EstacionamientoDTO> toDtoList(List<Estacionamiento> entityList);

}
