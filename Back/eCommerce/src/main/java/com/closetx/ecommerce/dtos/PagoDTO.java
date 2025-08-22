package com.closetx.ecommerce.dtos;

import com.closetx.ecommerce.entities.Factura;
import com.closetx.ecommerce.entities.enums.Estado;
import com.closetx.ecommerce.entities.enums.Metodo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagoDTO {
    private Integer id_pago;
    private Factura factura;
    private Metodo metodo;
    private Estado estado;
    private Date fecha;
}
