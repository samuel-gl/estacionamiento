package com.samuelgl.estacionamiento.servicio;

import com.samuelgl.estacionamiento.DTO.RegistroDTO;
import com.samuelgl.estacionamiento.DTO.UsuarioDTO;
import com.samuelgl.estacionamiento.entidad.Sesion;
import com.samuelgl.estacionamiento.entidad.Usuario;
import com.samuelgl.estacionamiento.mapper.EstacionamientoMapper;
import com.samuelgl.estacionamiento.mapper.EstacionamientoMapperImpl;
import com.samuelgl.estacionamiento.mapper.UsuarioMapper;
import com.samuelgl.estacionamiento.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio implements UserDetailsService {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        ;
        if(usuarioRepositorio.findById(nombreUsuario).isPresent()){
            Usuario usuario = usuarioRepositorio.findById(nombreUsuario).get();
            List<GrantedAuthority> permissions = new ArrayList<>();
            GrantedAuthority p = new SimpleGrantedAuthority("ROLE_" + usuario.getRol().toString());
            permissions.add(p);
            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            HttpSession session = attr.getRequest().getSession();
            session.setAttribute("customersession",usuario);
            return new User(usuario.getNombreUsuario(), usuario.getContrasena(),permissions);
        } else{
            return null;
        }
    }

    @Transactional
    public UsuarioDTO registrarUsuario(RegistroDTO dto){

        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(dto.getNombreUsuario());
        usuario.setEstacionamiento(dto.getEstacionamiento());
        String contrasena = dto.getContrasena();
        usuario.setContrasena(new BCryptPasswordEncoder().encode(contrasena));

        return usuarioMapper.toDTO(usuarioRepositorio.save(usuario));
    }

    public List<UsuarioDTO> verUsuarios(){

        return usuarioMapper.toDtoList(usuarioRepositorio.findAll());
    }

    public UsuarioDTO cambiarContrasena(RegistroDTO dto){
        Usuario usuario = usuarioRepositorio.findById(dto.getNombreUsuario()).get();
        usuario.setContrasena(new BCryptPasswordEncoder().encode(dto.getContrasena()));

        return usuarioMapper.toDTO(usuarioRepositorio.save(usuario));
    }


}
