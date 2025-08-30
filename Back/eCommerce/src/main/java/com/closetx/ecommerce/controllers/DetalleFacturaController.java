package com.closetx.ecommerce.controllers;

import com.closetx.ecommerce.dtos.Detalle_FacturaDTO;
import com.closetx.ecommerce.service.DetalleFacturaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/detalles")
@RequiredArgsConstructor
public class DetalleFacturaController {
    private final DetalleFacturaService detalleFacturaService;

    @GetMapping("/factura/{id_factura}")
    public ResponseEntity<List<Detalle_FacturaDTO>> getDetallesPorFactura(@PathVariable Integer id_factura) {
        List<Detalle_FacturaDTO> detalles = detalleFacturaService.listarDetalles(id_factura);
        return ResponseEntity.ok(detalles);
    }


}
