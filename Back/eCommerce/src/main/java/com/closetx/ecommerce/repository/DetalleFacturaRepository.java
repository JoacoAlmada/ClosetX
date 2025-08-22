package com.closetx.ecommerce.repository;

import com.closetx.ecommerce.entities.Detalle_Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleFacturaRepository extends JpaRepository<Detalle_Factura, Long> {
}
