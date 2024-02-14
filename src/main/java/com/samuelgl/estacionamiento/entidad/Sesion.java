package com.samuelgl.estacionamiento.entidad;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.samuelgl.estacionamiento.enums.Vehiculo;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@Entity
public class Sesion {
    @Id
    @Column(length = 100)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Boolean esActiva;
    private String placa;
    @Enumerated(EnumType.STRING)
    private Vehiculo tipo;
    private Double pagoActual;

    @ManyToOne(targetEntity = Estacionamiento.class)
    private Long idEstacionamiento;

    //@Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime inicioSesion;

    //@Temporal(TemporalType.TIME)
    //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime finSesion;

}

