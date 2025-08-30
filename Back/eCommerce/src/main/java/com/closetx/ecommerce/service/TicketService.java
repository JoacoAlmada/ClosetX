package com.closetx.ecommerce.service;

import com.closetx.ecommerce.dtos.TicketDTO;
import com.closetx.ecommerce.entities.Factura;
import com.closetx.ecommerce.entities.Tickets;
import com.closetx.ecommerce.repository.FacturaRepository;
import com.closetx.ecommerce.repository.TicketRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private FacturaRepository facturaRepository;
    @Autowired
    private ModelMapper modelMapper;

    public TicketDTO generarTicket(Integer id_factura, String url) {
        Factura factura = facturaRepository.findById(id_factura)
                .orElseThrow(() -> new RuntimeException("Factura no encontrada"));

        Tickets ticket = new Tickets();
        ticket.setFactura(factura);
        ticket.setUrl_ticket(url);
        ticket.setFecha_ticket(new Date());

        Tickets guardado = ticketRepository.save(ticket);
        return modelMapper.map(guardado, TicketDTO.class);
    }

    public TicketDTO obtenerTicket(Integer id_ticket) {
        Tickets ticket = ticketRepository.findById(id_ticket)
                .orElseThrow(() -> new RuntimeException("Ticket no encontrado"));
        return modelMapper.map(ticket, TicketDTO.class);
    }

    public List<TicketDTO> listarTicketsPorFactura(Integer id_factura) {
        return ticketRepository.findByFacturaId(id_factura)
                .stream()
                .map(t -> modelMapper.map(t, TicketDTO.class))
                .toList();
    }
}
