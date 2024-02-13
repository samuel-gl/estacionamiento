package com.samuelgl.estacionamiento.repositorio;

import com.samuelgl.estacionamiento.entidad.Sesion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SesionRepositorio extends JpaRepository<Sesion, String> {

    @Query(value = "SELECT s FROM Sesion s WHERE s.placa = :placa AND s.esActiva = true")
    public Optional<Sesion> buscarSesionActivaPorPlaca(@Param("placa") String placa);

    @Query(value = "SELECT s FROM Sesion s WHERE s.estacionamiento = :idEstacionamiento AND s.esActiva = true")
    public Optional<Sesion> buscarSesionesActivasPorEstacionamiento(@Param("idEstacionamiento") Long idEstacionamiento);

    @Query(value = "SELECT all FROM Sesion s WHERE s.esActiva = true")
    public List<Sesion> buscarSesionesActivas();

}
