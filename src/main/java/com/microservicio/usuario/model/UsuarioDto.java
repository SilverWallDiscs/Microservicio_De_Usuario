package com.microservicio.usuario.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor@AllArgsConstructor
public class UsuarioDto {
    private int idUsuario;
    private String nombre;
    private String correo;

}
