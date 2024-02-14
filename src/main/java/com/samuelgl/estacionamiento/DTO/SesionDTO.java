package com.samuelgl.estacionamiento.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.samuelgl.estacionamiento.enums.Vehiculo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;
import java.util.Calendar;

@Getter
@Setter
@NoArgsConstructor
public class SesionDTO {

    private String placa;
    @Enumerated(EnumType.STRING)
    private Vehiculo tipo;
    private Double pagoActual;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime finSesion;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime inicioSesion;
}
