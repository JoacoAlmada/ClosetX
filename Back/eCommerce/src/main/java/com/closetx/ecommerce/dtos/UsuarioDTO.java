package com.closetx.ecommerce.dtos;

import com.closetx.ecommerce.entities.enums.Rol;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private Integer id_usuario;
    private String nombre_Completo;
    private String email;
    private String contrasenia;
    private Rol rol;
    private String dni;
    private String Pais;
    private String provincia;
    private String direccion;
    private Integer numero;
    private LocalDate fecha_Registro;

    //Agregar validaciones
}
