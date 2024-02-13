package com.samuelgl.estacionamiento.repositorio;

import com.samuelgl.estacionamiento.entidad.Estacionamiento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstacionamientoRepositorio extends JpaRepository<Estacionamiento, Long> {
}
