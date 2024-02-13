package com.samuelgl.estacionamiento.DTO;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EstacionamientoDTO {
    private Double tarifaAuto;
    private Double tarifaMoto;

    private Integer celdasAuto;
    private Integer celdasMoto;

    private Integer disponiblesAuto;
    private Integer disponiblesMoto;
}
