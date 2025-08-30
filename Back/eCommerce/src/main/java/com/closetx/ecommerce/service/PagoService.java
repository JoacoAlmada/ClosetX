package com.closetx.ecommerce.service;

import com.closetx.ecommerce.dtos.PagoDTO;
import com.closetx.ecommerce.entities.Factura;
import com.closetx.ecommerce.entities.Pago;
import com.closetx.ecommerce.entities.Tickets;
import com.closetx.ecommerce.entities.enums.Estado;
import com.closetx.ecommerce.repository.FacturaRepository;
import com.closetx.ecommerce.repository.PagoRepository;
import com.closetx.ecommerce.repository.TicketRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PagoService {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private PagoRepository pagoRepository;
    @Autowired
    private FacturaRepository facturaRepository;
    @Autowired
    private ModelMapper modelMapper;

    public PagoDTO registrarPago(PagoDTO pagoDTO) {
        Factura factura = facturaRepository.findById(pagoDTO.getFactura().getId_factura())
                .orElseThrow(() -> new RuntimeException("Factura no encontrada"));

        Pago pago = modelMapper.map(pagoDTO, Pago.class);
        pago.setFactura(factura);
        pago.setEstado(Estado.Pendiente);
        pago.setFecha(new Date());

        Pago saved = pagoRepository.save(pago);
        return modelMapper.map(saved, PagoDTO.class);
    }

    @Transactional
    public PagoDTO confirmarPago(Integer id_pago) {
        Pago pago = pagoRepository.findById(id_pago)
                .orElseThrow(() -> new RuntimeException("Pago no encontrado"));

        pago.setEstado(Estado.Aprobado);
        pagoRepository.save(pago);

        Factura factura = pago.getFactura();
        Double totalPagado = pagoRepository.sumPagosConfirmadosByFactura(factura.getId_factura());

        if (totalPagado >= factura.getTotal()) {
            factura.setEstado(Estado.Pagado);
            facturaRepository.save(factura);

            Tickets ticket = new Tickets();
            ticket.setFactura(factura);
            ticket.setFecha_ticket(new Date());
            ticket.setUrl_ticket("http://localhost:8080/tickets/" + factura.getId_factura());

            ticketRepository.save(ticket);
        }

        return modelMapper.map(pago, PagoDTO.class);
    }

    public PagoDTO rechazarPago(Integer id_pago) {
        Pago pago = pagoRepository.findById(id_pago)
                .orElseThrow(() -> new RuntimeException("Pago no encontrado"));

        pago.setEstado(Estado.Rechazado);
        pagoRepository.save(pago);

        return modelMapper.map(pago, PagoDTO.class);
    }

    public List<PagoDTO> obtenerPagosPorFactura(Integer id_factura) {
        List<Pago> pagos = pagoRepository.findByFacturaId(id_factura);
        return pagos.stream()
                .map(p -> modelMapper.map(p, PagoDTO.class))
                .collect(Collectors.toList());
    }
}
