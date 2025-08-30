package com.closetx.ecommerce.repository;

import com.closetx.ecommerce.entities.Detalle_Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface DetalleFacturaRepository extends JpaRepository<Detalle_Factura, Integer> {
    @Query("SELECT d FROM Detalle_Factura d WHERE d.factura.id_factura = :idFactura")
    Collection<Detalle_Factura> findByFacturaId(@Param("idFactura") Integer idFactura);}
