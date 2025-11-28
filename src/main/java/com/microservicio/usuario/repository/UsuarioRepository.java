package com.microservicio.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservicio.usuario.entity.UsuarioEntity;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    boolean existsByCorreo(String correo);
    UsuarioEntity findByIdUsuario(Long idUsuario); // o usa findById(id) de JpaRepository
}
