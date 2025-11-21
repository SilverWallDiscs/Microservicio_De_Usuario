package com.microservicio.usuario;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.microservicio.usuario.entity.UsuarioEntity;
import com.microservicio.usuario.model.Usuario;
import com.microservicio.usuario.model.UsuarioDto;
import com.microservicio.usuario.repository.UsuarioRepository;
import com.microservicio.usuario.service.UsuarioService;

public class testUsuario {
    @Mock 
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    private Usuario usuario;
    private UsuarioDto usuarioDto;
    private UsuarioEntity usuarioEntity;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        usuarioDto = new UsuarioDto();
        usuarioDto.setIdUsuario(1);
        usuarioDto.setNombre("pepe");
        usuarioDto.setCorreo("pepe@example.com");

        usuario = new Usuario();
        usuario.setIdUsuario(1);
        usuario.setNombre("pepe");
        usuario.setCorreo("pepe@example.com");
        usuario.setContrasena("password");

        usuarioEntity = new UsuarioEntity();
        usuarioEntity.setIdUsuario(1);
        usuarioEntity.setNombre("pepe");
        usuarioEntity.setCorreo("pepe@example.com");
        usuarioEntity.setContrasena("password");
        }

    @Test
    public void testCrearUsuario() {
        when(usuarioRepository.existsByIdUsuario(usuario.getIdUsuario())).thenReturn(false);
        when(usuarioRepository.save(any(UsuarioEntity.class))).thenReturn(usuarioEntity);

        boolean result = usuarioService.crearUsuario(usuario);
        assertEquals(true,result);

    }

    @Test
    public void testCrearUsuarioExistente() {
        when(usuarioRepository.existsByIdUsuario(usuario.getIdUsuario())).thenReturn(true);

        boolean result = usuarioService.crearUsuario(usuario);
        assertEquals(false, result);
    }

    @Test
    public void testObtenerUsuarioPorId() {
        when(usuarioRepository.findByIdUsuario(usuario.getIdUsuario())).thenReturn(usuarioEntity);

        
        UsuarioDto result = usuarioService.traerUsuario(usuario.getIdUsuario());
        assertEquals(usuarioDto,result);
    }

    @Test
    public void testObtenerUsuarioPorIdNoExistente() {
        when(usuarioRepository.findByIdUsuario(usuario.getIdUsuario())).thenReturn(null);

        UsuarioDto result = usuarioService.traerUsuario(usuario.getIdUsuario());
        assertEquals(null,result);
    }


    @Test
    public void testActualizarUsuario() {
        when(usuarioRepository.findById(usuario.getIdUsuario())).thenReturn(Optional.of(usuarioEntity));
        when(usuarioRepository.save(usuarioEntity)).thenReturn(usuarioEntity);

        boolean result = usuarioService.actualizarUsuario(usuario.getIdUsuario(), usuario);
        assertEquals(true, result);
    }



    @Test
    public void testActualizarUsuarioNoExistente() {
        when(usuarioRepository.existsByIdUsuario(usuario.getIdUsuario())).thenReturn(false);
        boolean result = usuarioService.actualizarUsuario(usuario.getIdUsuario(), usuario);
        assertEquals(false, result);
    }


   



}
