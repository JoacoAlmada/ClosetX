package com.closetx.ecommerce.dtos;

import com.closetx.ecommerce.entities.Factura;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketDTO {
    private Integer id_ticket;
    private Factura factura;
    private String url_ticket;
    private Date fecha_ticket;
}
