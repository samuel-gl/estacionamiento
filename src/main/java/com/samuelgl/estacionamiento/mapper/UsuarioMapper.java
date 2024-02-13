package com.samuelgl.estacionamiento.mapper;

import com.samuelgl.estacionamiento.DTO.EstacionamientoDTO;
import com.samuelgl.estacionamiento.DTO.UsuarioDTO;
import com.samuelgl.estacionamiento.entidad.Estacionamiento;
import com.samuelgl.estacionamiento.entidad.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UsuarioMapper {

    public Usuario toEnitity(UsuarioDTO DTO);
    public UsuarioDTO toDTO(Usuario entity);
    public List<UsuarioDTO> toDtoList(List<Usuario> entityList);
}