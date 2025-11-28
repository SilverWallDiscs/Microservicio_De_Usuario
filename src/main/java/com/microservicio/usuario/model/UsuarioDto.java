package com.microservicio.usuario.model;
import lombok.Data;
@Data
public class UsuarioDto {
    private Long idUsuario;
    private String nombre;
    private String correo;
}
