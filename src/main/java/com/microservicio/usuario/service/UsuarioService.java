package com.microservicio.usuario.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservicio.usuario.entity.UsuarioEntity;
import com.microservicio.usuario.model.Usuario;
import com.microservicio.usuario.model.UsuarioDto;
import com.microservicio.usuario.repository.UsuarioRepository;

import jakarta.transaction.Transactional;



@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    UsuarioEntity ue = new UsuarioEntity();

    public Boolean crearUsuario(Usuario u) {

    if (usuarioRepository.existsByIdUsuario(u.getIdUsuario())) {
        System.out.println("El usuario ya existe");
        return false;

    } else {
        ue.setIdUsuario(u.getIdUsuario());
        ue.setNombre(u.getNombre());
        ue.setCorreo(u.getCorreo());
        ue.setContrasena(u.getContrasena());
        usuarioRepository.save(ue);
        System.out.println("Usuario creado correctamente");
        return true;
    }
}


    
    public UsuarioDto traerUsuario(int id){

        try {
            UsuarioEntity usuarioDB = usuarioRepository.findByIdUsuario(id);
            if (usuarioDB != null) {
                UsuarioDto u = new UsuarioDto();
                u.setIdUsuario(usuarioDB.getIdUsuario());
                u.setNombre(usuarioDB.getNombre());
                u.setCorreo(usuarioDB.getCorreo());
                
                return u;
            } 


        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
        return null;

    }

    public Boolean actualizarUsuario(int id,Usuario u){
        try {
            Optional<UsuarioEntity> usuarioDB = usuarioRepository.findById(id);
            if (usuarioDB.isPresent()) {
                UsuarioEntity usuario = usuarioDB.get();
                usuario.setNombre(u.getNombre());
                usuario.setCorreo(u.getCorreo());
                usuario.setContrasena(u.getContrasena());
                usuarioRepository.save(usuario);
                return true;
            } else {
                return false;
            }

            
        } catch (Exception e) {
            // TODO: handle exception
        }

        return false;

    }

@Transactional
public boolean eliminarUsuario(int idU) {
    try {
        UsuarioEntity u = usuarioRepository.findByIdUsuario(idU);

        if (u != null) {
            usuarioRepository.deleteByIdUsuario(idU);
            return true;
        } else {
            return false;
        }
    } catch (Exception e) {
        return false;
    }
}



}
