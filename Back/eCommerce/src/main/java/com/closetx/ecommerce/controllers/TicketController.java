package com.closetx.ecommerce.controllers;

import com.closetx.ecommerce.dtos.TicketDTO;
import com.closetx.ecommerce.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tickets")
@RequiredArgsConstructor
public class TicketController {
    private final TicketService ticketService;

    @GetMapping("/{id_ticket}")
    public ResponseEntity<TicketDTO> getTicket(@PathVariable Integer id_ticket) {
        return ResponseEntity.ok(ticketService.obtenerTicket(id_ticket));
    }

    @GetMapping("/factura/{id_factura}")
    public ResponseEntity<List<TicketDTO>> listarTicketsPorFactura(@PathVariable Integer id_factura) {
        return ResponseEntity.ok(ticketService.listarTicketsPorFactura(id_factura));
    }
}
