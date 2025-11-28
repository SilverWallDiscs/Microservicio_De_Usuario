package com.microservicio.usuario.model;
import lombok.Data;
@Data
public class Usuario {
    private Long idUsuario;
    private String nombre;
    private String correo;
    private String contrasena;
}
