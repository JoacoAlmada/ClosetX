package com.closetx.ecommerce.dtos;

import com.closetx.ecommerce.entities.Usuario;
import com.closetx.ecommerce.entities.enums.Estado;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FacturaDTO {
    private Integer id_factura;
    private Usuario usuario;
    private Date fecha;
    private Double total;
    private Estado estado;
}
