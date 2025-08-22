package com.closetx.ecommerce.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDTO {
    private Integer id_producto;
    private String nombre;
    private String descripcion;
    private String marca;
    private String categoria;
    private String talle;
    private Integer stock;
    private Double precio;
    private String imagen;
}
