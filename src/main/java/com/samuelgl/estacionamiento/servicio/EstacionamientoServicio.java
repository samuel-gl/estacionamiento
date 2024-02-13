package com.samuelgl.estacionamiento.servicio;

import com.samuelgl.estacionamiento.DTO.EstacionamientoDTO;
import com.samuelgl.estacionamiento.entidad.Estacionamiento;
import com.samuelgl.estacionamiento.mapper.EstacionamientoMapper;
import com.samuelgl.estacionamiento.repositorio.EstacionamientoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EstacionamientoServicio {


    @Autowired
    private EstacionamientoRepositorio estacionamientoRepositorio;


    @Autowired
    private EstacionamientoMapper estacionamientoMapper;

    @Transactional
    public EstacionamientoDTO crearEstacionamiento(EstacionamientoDTO dto){

        Estacionamiento estacionamiento = estacionamientoMapper.toEnitity(dto);

        return estacionamientoMapper.toDTO(estacionamientoRepositorio.save(estacionamiento));
    }

    @Transactional
    public EstacionamientoDTO editarEstacionamiento(Long id, EstacionamientoDTO dto){

        Estacionamiento estacionamiento = estacionamientoRepositorio.findById(id).get();
        estacionamiento.setCeldasAuto(dto.getCeldasAuto());
        estacionamiento.setCeldasMoto(dto.getCeldasMoto());
        estacionamiento.setHoraAuto(dto.getTarifaAuto()); //PENDIENTE CAMBIAR TARIFA POR DIA Y HORA
        estacionamiento.setHoraMoto(dto.getTarifaMoto()); //PENDIENTE CAMBIAR TARIFA POR DIA Y HORA
        estacionamiento.setDisponiblesAuto(dto.getDisponiblesAuto());
        estacionamiento.setDisponiblesMoto(dto.getDisponiblesMoto());

        return estacionamientoMapper.toDTO(estacionamientoRepositorio.save(estacionamiento));
    }

    public List<EstacionamientoDTO> buscarEstacionamientos(){

        return estacionamientoMapper.toDtoList(estacionamientoRepositorio.findAll());
    }
    public EstacionamientoDTO buscarEstacionamientoPorId(Long id){

        return estacionamientoMapper.toDTO(estacionamientoRepositorio.findById(id).get());
    }

}
