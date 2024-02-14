package com.samuelgl.estacionamiento.DTO;

import com.samuelgl.estacionamiento.entidad.Estacionamiento;
import com.samuelgl.estacionamiento.enums.Rol;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioDTO {
    private String nombreUsuario;
    @ManyToOne
    private Estacionamiento estacionamiento;
    @Enumerated(EnumType.STRING)
    private Rol rol;
}
