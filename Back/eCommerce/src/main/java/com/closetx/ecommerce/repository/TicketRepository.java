package com.closetx.ecommerce.repository;

import com.closetx.ecommerce.entities.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Tickets, Integer> {
}
