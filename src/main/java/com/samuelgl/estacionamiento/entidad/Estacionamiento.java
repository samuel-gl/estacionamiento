package com.samuelgl.estacionamiento.entidad;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Estacionamiento {

    @Id
    @Column(length = 100)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEstacionamiento;

    private Double horaMoto;
    private Double horaAuto;

    private Double diaMoto;
    private Double diaAuto;

    private Integer celdasAuto;
    private Integer celdasMoto;

    private Integer disponiblesAuto;
    private Integer disponiblesMoto;





}
