package com.samuelgl.estacionamiento.DTO;

import com.samuelgl.estacionamiento.entidad.Estacionamiento;
import com.samuelgl.estacionamiento.enums.Rol;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
public class RegistroDTO {

    private String nombreUsuario;
    private String contrasena;
    private Estacionamiento estacionamiento;
    private Rol rol;

}
