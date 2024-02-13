package com.samuelgl.estacionamiento.entidad;

import com.samuelgl.estacionamiento.enums.Rol;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Usuario {
    @Id
    @Column(length = 100)
    private String nombreUsuario;
    private String contrasena;
    @ManyToOne
    private Estacionamiento estacionamiento;

    private Rol rol;
}
