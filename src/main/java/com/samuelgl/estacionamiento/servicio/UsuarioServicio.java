package com.samuelgl.estacionamiento.servicio;

import com.samuelgl.estacionamiento.DTO.RegistroDTO;
import com.samuelgl.estacionamiento.DTO.UsuarioDTO;
import com.samuelgl.estacionamiento.entidad.Sesion;
import com.samuelgl.estacionamiento.entidad.Usuario;
import com.samuelgl.estacionamiento.mapper.EstacionamientoMapper;
import com.samuelgl.estacionamiento.mapper.EstacionamientoMapperImpl;
import com.samuelgl.estacionamiento.mapper.UsuarioMapper;
import com.samuelgl.estacionamiento.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UsuarioServicio {


    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Transactional
    public UsuarioDTO registrarUsuario(RegistroDTO dto){

        Usuario usuario;


        return null;
    }

    public List<UsuarioDTO> verUsuarios(){

        return usuarioMapper.toDtoList(usuarioRepositorio.findAll());
    }



}
