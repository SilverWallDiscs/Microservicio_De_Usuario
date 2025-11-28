package com.microservicio.usuario.model;
import lombok.Data;
@Data
public class Usuario {
    // Para POST no es necesario enviar idUsuario
    private Long idUsuario; // opcional para PUT/GET
    private String nombre;
    private String correo;
    private String contrasena;
}
