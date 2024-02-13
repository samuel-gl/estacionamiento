package com.samuelgl.estacionamiento.repositorio;


import com.samuelgl.estacionamiento.entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, String> {
}
