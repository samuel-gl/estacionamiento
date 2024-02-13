package com.samuelgl.estacionamiento.controller;


import com.samuelgl.estacionamiento.DTO.EstacionamientoDTO;
import com.samuelgl.estacionamiento.DTO.RegistroDTO;
import com.samuelgl.estacionamiento.DTO.UsuarioDTO;
import com.samuelgl.estacionamiento.servicio.EstacionamientoServicio;
import com.samuelgl.estacionamiento.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {


    @Autowired
    UsuarioServicio usuarioServicio;

    @Autowired
    EstacionamientoServicio estacionamientoServicio;




    @GetMapping("/usuarios")
    public ResponseEntity<List<UsuarioDTO>> verUsuarios(){

        List<UsuarioDTO> listaUsuariosDTO = usuarioServicio.verUsuarios();

        return new ResponseEntity<>(listaUsuariosDTO, HttpStatus.OK);
    }


    @PostMapping("usuarios/crearUsuario") //PENDIENTE MODIFICAR CUANDO APLIQUE SECURITY
    public ResponseEntity<UsuarioDTO> registrarUsuario(RegistroDTO registroDTO) {

        UsuarioDTO dto = usuarioServicio.registrarUsuario(registroDTO);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/estacionamientos")
    public ResponseEntity<List<EstacionamientoDTO>> verEstacionamientos(){

        List<EstacionamientoDTO> listaDTO = estacionamientoServicio.buscarEstacionamientos();

        return new ResponseEntity<>(listaDTO,HttpStatus.OK);
    }

    @PostMapping("/estacionamientos/crearEstacionamiento")
    public ResponseEntity<EstacionamientoDTO> registrarEstacionamiento(EstacionamientoDTO estacionamientoDTO){

        estacionamientoDTO = estacionamientoServicio.crearEstacionamiento(estacionamientoDTO);

        return new ResponseEntity<>(estacionamientoDTO, HttpStatus.OK);
    }



}
