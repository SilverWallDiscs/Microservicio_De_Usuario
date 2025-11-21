package com.microservicio.usuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicio.usuario.model.Usuario;
import com.microservicio.usuario.model.UsuarioDto;
import com.microservicio.usuario.service.UsuarioService;



@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/")
    ResponseEntity<Boolean> agregarUsuario(@RequestBody Usuario usuario){
        if (usuarioService.crearUsuario(usuario)) {
            System.out.println("Usuario creado correctamente");
            return ResponseEntity.ok(true);
        } else {
            System.out.println("El usuario ya existe");
            return ResponseEntity.badRequest().build();
        }
        
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<UsuarioDto> obtenerUsuario(@PathVariable int idUsuario){ 
        if (usuarioService.traerUsuario(idUsuario) != null) {
            return ResponseEntity.ok(usuarioService.traerUsuario(idUsuario));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{idUsuario}")
    public ResponseEntity<Boolean> actualizarUsuario(@PathVariable int idUsuario, @RequestBody Usuario usuario){
        if (usuarioService.actualizarUsuario(idUsuario, usuario)) {
            return ResponseEntity.ok(usuarioService.actualizarUsuario(idUsuario, usuario));
        } else {
            return ResponseEntity.notFound().build();
        }
        
    }

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<Boolean> eliminarUsuario(@PathVariable int idUsuario){
        if (usuarioService.eliminarUsuario(idUsuario)) {
            return ResponseEntity.ok(usuarioService.eliminarUsuario(idUsuario));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
