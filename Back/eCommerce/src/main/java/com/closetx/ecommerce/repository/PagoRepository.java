package com.closetx.ecommerce.repository;

import com.closetx.ecommerce.entities.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Integer> {
    @Query("SELECT COALESCE(SUM(p.factura.total), 0) " +
            "FROM Pago p " +
            "WHERE p.factura.id_factura = :idFactura " +
            "AND p.estado = com.closetx.ecommerce.entities.enums.Estado.Aprobado")
    Double sumPagosConfirmadosByFactura(@Param("idFactura") Integer idFactura);

    @Query("SELECT p FROM Pago p WHERE p.factura.id_factura = :idFactura")
    List<Pago> findByFacturaId(@Param("idFactura") Integer idFactura);
}
