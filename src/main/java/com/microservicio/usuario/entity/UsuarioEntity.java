package com.microservicio.usuario.entity;
import jakarta.persistence.*;
import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USUARIO")
public class UsuarioEntity {
    @Id
    @SequenceGenerator(name = "USUARIO_SEQ_GEN", sequenceName = "USUARIO_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO_SEQ_GEN")
    @Column(name = "ID_USUARIO")
    private Long idUsuario;
    @Column(name = "NOMBRE", length = 100, nullable = false)
    private String nombre;
    @Column(name = "CORREO", length = 150, nullable = false, unique = true)
    private String correo;
    @Column(name = "CONTRASENA", length = 200, nullable = false)
    private String contrasena;
}
