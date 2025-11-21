package com.microservicio.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservicio.usuario.entity.UsuarioEntity;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer>{

    UsuarioEntity findByIdUsuario(int idUsuario);
    Boolean existsByIdUsuario(int idUsuario);
    void deleteByIdUsuario(int idUsuario);

    
}


