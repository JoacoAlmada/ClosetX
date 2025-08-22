package com.closetx.ecommerce.dtos;

import com.closetx.ecommerce.entities.Factura;
import com.closetx.ecommerce.entities.Producto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Detalle_FacturaDTO {
    private Integer id_detalle_Factura;
    private Factura factura;
    private Producto producto;
    private Integer cantidad;
    private Double precio_Unitario;
    private Double subTotal;
}
