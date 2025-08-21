package com.closetx.ecommerce.entities;

import com.closetx.ecommerce.entities.enums.Estado;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name = "facturas")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_factura;
    @ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuario;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    private Double total;
    @Enumerated(EnumType.STRING)
    private Estado estado;

}
