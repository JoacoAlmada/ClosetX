package com.closetx.ecommerce.entities;

import com.closetx.ecommerce.entities.enums.Rol;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name = "usuarios")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;
    private String nombre_Completo;
    private String email;
    private String contrasenia;
    @Enumerated(EnumType.STRING)
    private Rol rol;
    private String dni;
    private String Pais;
    private String provincia;
    private String direccion;
    private Integer numero;
    @Temporal(TemporalType.DATE)
    private Date fecha_Registro;
}
