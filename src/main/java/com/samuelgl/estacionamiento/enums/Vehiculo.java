package com.samuelgl.estacionamiento.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Vehiculo {
    AUTO("AUTO"),
    MOTO("MOTO");

    @JsonValue
    private final String jsonValue;

    Vehiculo(String jsonValue) {
        this.jsonValue = jsonValue; }

}
