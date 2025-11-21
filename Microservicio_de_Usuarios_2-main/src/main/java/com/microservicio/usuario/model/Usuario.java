package com.microservicio.usuario.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {


    @Id
    private int idUsuario;
    
    private String nombre;
    private String correo;
    private String contrasena;

}
