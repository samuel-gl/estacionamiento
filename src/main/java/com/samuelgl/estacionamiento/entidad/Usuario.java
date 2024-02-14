package com.samuelgl.estacionamiento.entidad;

import com.samuelgl.estacionamiento.enums.Rol;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Usuario implements Serializable {
    @Id
    @Column(length = 100)
    private String nombreUsuario;
    private String contrasena;
    @ManyToOne
    private Estacionamiento estacionamiento;
    @Enumerated(EnumType.STRING)
    private Rol rol;
}
