package com.closetx.ecommerce.dtos;

import com.closetx.ecommerce.entities.enums.Rol;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AltaUsuarioDTO {
    private String nombre_Completo;
    private String email;
    private String contrasenia;
    @JsonIgnore
    private Rol rol;
    private String dni;
    private String Pais;
    private String provincia;
    private String direccion;
    private Integer numero;
    @JsonIgnore
    private LocalDate fecha_Registro;
}
