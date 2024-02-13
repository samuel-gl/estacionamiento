package com.samuelgl.estacionamiento.controller;

import com.samuelgl.estacionamiento.DTO.RegistroDTO;
import com.samuelgl.estacionamiento.DTO.UsuarioDTO;
import com.samuelgl.estacionamiento.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registro")
public class RegistroController {

    @Autowired
    UsuarioServicio usuarioServicio;

    @PostMapping("")
    public ResponseEntity<UsuarioDTO> registrarUsuario(RegistroDTO registroDTO){

        UsuarioDTO dto = usuarioServicio.registrarUsuario(registroDTO);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}
