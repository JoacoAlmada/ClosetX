package com.closetx.ecommerce.dtos;

import com.closetx.ecommerce.entities.enums.Rol;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {
    @NotBlank
    @NotNull(message = "Ingrese tu email")
    private String email;
    @NotBlank
    @NotNull (message = "Ingrese tu contraseña")
    private String contrasenia;
    @NotNull(message = "Seleccione un rol")
    private Rol rol;
}
