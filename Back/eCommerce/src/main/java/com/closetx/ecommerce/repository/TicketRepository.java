package com.closetx.ecommerce.repository;

import com.closetx.ecommerce.entities.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface TicketRepository extends JpaRepository<Tickets, Integer> {
    @Query("SELECT t FROM Tickets t WHERE t.factura.id_factura = :idFactura")
    Collection<Tickets> findByFacturaId(@Param("idFactura") Integer idFactura);}
