package com.closetx.ecommerce.entities;

import com.closetx.ecommerce.entities.enums.Estado;
import com.closetx.ecommerce.entities.enums.Metodo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name = "pago")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pago;
    @OneToOne
    @JoinColumn(name = "id_factura")
    private Factura factura;
    @Enumerated(EnumType.STRING)
    private Metodo metodo;
    @Enumerated(EnumType.STRING)
    private Estado estado;
    private Date fecha;
}
