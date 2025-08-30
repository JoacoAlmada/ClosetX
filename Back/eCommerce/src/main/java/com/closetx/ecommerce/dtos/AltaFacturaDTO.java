package com.closetx.ecommerce.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AltaFacturaDTO {
    private Integer id_usuario;
    private List<ProductoCompraDTO> productos;
}
