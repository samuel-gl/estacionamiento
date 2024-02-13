package com.samuelgl.estacionamiento.servicio;

import com.samuelgl.estacionamiento.DTO.SesionDTO;
import com.samuelgl.estacionamiento.entidad.Estacionamiento;
import com.samuelgl.estacionamiento.entidad.Sesion;
import com.samuelgl.estacionamiento.mapper.SesionMapper;
import com.samuelgl.estacionamiento.repositorio.SesionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


@Service
public class SesionServicio {

    @Autowired
    private SesionRepositorio sesionRepositorio;

    //@Autowired
    //private Estacionamiento estacionamiento;
    @Autowired
    private SesionMapper sesionMapper;

    @Transactional
    public SesionDTO iniciarSesion(SesionDTO dto) throws Exception {

        if(sesionRepositorio.buscarSesionActivaPorPlaca(dto.getPlaca()).isPresent()){
            throw new Exception("Ya hay una sesion activa con esta placa");
        } else{
            Sesion sesion = new Sesion();

            sesion.setInicioSesion(LocalDateTime.now());
            sesion.setTipo(dto.getTipo());
            sesion.setPlaca(dto.getPlaca());
            sesion.setEsActiva(true);
            //sesion.setIdEstacionamiento(1L);

            return sesionMapper.toDTO(sesionRepositorio.save(sesion));
        }

    }

    @Transactional
    public SesionDTO finalizarSesion(String placa) throws Exception {

        if(sesionRepositorio.buscarSesionActivaPorPlaca(placa).isPresent()){
            Sesion sesion = sesionRepositorio.buscarSesionActivaPorPlaca(placa).get();
            sesion.setFinSesion(LocalDateTime.now());

            sesion.setEsActiva(false);

            return sesionMapper.toDTO(sesionRepositorio.save(sesion));

        } else {
            throw new Exception("no existe una sesion activa asociada a la placa");
        }


    }

    public Double calcularPrecioFinal(String placa) throws Exception {
        if(sesionRepositorio.buscarSesionActivaPorPlaca(placa).isPresent()) {
            Sesion sesion = sesionRepositorio.buscarSesionActivaPorPlaca(placa).get();

            Long tiempo = (sesion.getInicioSesion().until(sesion.getFinSesion(), ChronoUnit.HOURS));

            System.out.println(tiempo * 10);

            return tiempo * 10.0;
        }else{
            throw new Exception("ERROR");
        }

    }

    public Double calcularPrecioFinal(SesionDTO dto){

        Long minutos = (dto.getInicioSesion().until(dto.getFinSesion(), ChronoUnit.MINUTES)) + 1;

        Double horas = Math.ceil(minutos/60.0);

        System.out.println(horas*10.0);

        return horas*10.0;
    }

    public SesionDTO informacionSesionPorPlaca(String placa) throws Exception {

        if (sesionRepositorio.buscarSesionActivaPorPlaca(placa).isPresent()) {
            SesionDTO dto = sesionMapper.toDTO(sesionRepositorio.buscarSesionActivaPorPlaca(placa).get());
            Long minutos = (dto.getInicioSesion().until(LocalDateTime.now()  , ChronoUnit.MINUTES)) + 1;
            Double horas = Math.ceil(minutos/60.0);
            System.out.println(horas*10.0);
            return dto;
        }
        else{
            throw new Exception("No hay sesion activa asociada a la placa");
        }
    }



}
