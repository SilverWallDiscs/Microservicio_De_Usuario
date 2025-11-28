// src/main/java/com/microservicio/usuario/service/UsuarioService.java
package com.microservicio.usuario.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import com.microservicio.usuario.entity.UsuarioEntity;
import com.microservicio.usuario.model.Usuario;
import com.microservicio.usuario.model.UsuarioDto;
import com.microservicio.usuario.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Boolean crearUsuario(Usuario u) {
        // No usar ID en creación. Evita el 0 -> merge. Deja que Oracle genere el ID.
        if (usuarioRepository.existsByCorreo(u.getCorreo())) {
            System.out.println("El correo ya existe");
            return false;
        }

        UsuarioEntity nuevo = new UsuarioEntity();
        nuevo.setIdUsuario(null); // Clave: null => Hibernate hace persist y Oracle genera el ID
        nuevo.setNombre(u.getNombre());
        nuevo.setCorreo(u.getCorreo());
        nuevo.setContrasena(u.getContrasena());

        usuarioRepository.save(nuevo);
        return true;
    }

    public UsuarioDto traerUsuario(long id) {
        UsuarioEntity usuarioDB = usuarioRepository.findByIdUsuario(id);
        if (usuarioDB == null) return null;

        UsuarioDto u = new UsuarioDto();
        // Asegúrate que UsuarioDto.idUsuario sea Long (ver punto 4)
        u.setIdUsuario(usuarioDB.getIdUsuario());
        u.setNombre(usuarioDB.getNombre());
        u.setCorreo(usuarioDB.getCorreo());
        return u;
    }

    public Boolean actualizarUsuario(long id, Usuario u) {
        UsuarioEntity usuario = usuarioRepository.findByIdUsuario(id);
        if (usuario == null) return false;

        usuario.setNombre(u.getNombre());
        usuario.setCorreo(u.getCorreo());
        usuario.setContrasena(u.getContrasena());
        usuarioRepository.save(usuario);
        return true;
    }

    public boolean eliminarUsuario(long idU) {
        UsuarioEntity u = usuarioRepository.findByIdUsuario(idU);
        if (u == null) return false;

        usuarioRepository.delete(u);
        return true;
    }
}