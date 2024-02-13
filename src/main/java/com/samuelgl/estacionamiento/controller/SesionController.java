package com.samuelgl.estacionamiento.controller;

import com.samuelgl.estacionamiento.DTO.SesionDTO;
import com.samuelgl.estacionamiento.entidad.Sesion;
import com.samuelgl.estacionamiento.servicio.SesionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sesion")
public class SesionController {

    @Autowired
    private SesionServicio sesionServicio;

    @PostMapping("/nuevasesion")
    public ResponseEntity<SesionDTO> iniciarNuevaSesion(@RequestBody SesionDTO sesion){

        try {
            sesion = sesionServicio.iniciarSesion(sesion);
            return new ResponseEntity<>(sesion, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }


    @GetMapping("/{placa}")
    public ResponseEntity<SesionDTO> mostrarInfoSesion(@PathVariable String placa){

        SesionDTO sesion = null;
        try {
            sesion = sesionServicio.informacionSesionPorPlaca(placa);
            return new ResponseEntity<>(sesion, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @PostMapping("/{placa}/finalizar")
    public ResponseEntity<SesionDTO> finalizarSesion(@PathVariable String placa){

        SesionDTO dto = null;
        try {
            dto = sesionServicio.finalizarSesion(placa);
            System.out.println(sesionServicio.calcularPrecioFinal(dto));

            return new ResponseEntity<>(dto, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
