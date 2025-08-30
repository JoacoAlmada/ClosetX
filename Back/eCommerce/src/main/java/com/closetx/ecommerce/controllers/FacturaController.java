package com.closetx.ecommerce.controllers;

import com.closetx.ecommerce.dtos.Detalle_FacturaDTO;
import com.closetx.ecommerce.dtos.FacturaDTO;
import com.closetx.ecommerce.entities.Usuario;
import com.closetx.ecommerce.entities.enums.Estado;
import com.closetx.ecommerce.service.DetalleFacturaService;
import com.closetx.ecommerce.service.FacturaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/facturas")
@RequiredArgsConstructor
public class FacturaController {
    private final FacturaService facturaService;
    private final DetalleFacturaService detalleFacturaService;

    @PostMapping
    public ResponseEntity<FacturaDTO> crearFactura(@RequestParam Integer id_usuario) {
        FacturaDTO creada = facturaService.crearFactura(id_usuario);
        return ResponseEntity.ok(creada);
    }

    @PostMapping("/{id_factura}/detalles")
    public ResponseEntity<Detalle_FacturaDTO> agregarDetalle(
            @PathVariable Integer id_factura,
            @RequestBody Detalle_FacturaDTO detalleDTO) {
        Detalle_FacturaDTO detalle = detalleFacturaService.agregarDetalle(id_factura, detalleDTO);
        return ResponseEntity.ok(detalle);
    }

    @GetMapping("/{id_factura}")
    public ResponseEntity<FacturaDTO> getFactura(@PathVariable Integer id_factura) {
        return ResponseEntity.ok(facturaService.obtenerFactura(id_factura));
    }

    @GetMapping
    public ResponseEntity<List<FacturaDTO>> listarFacturas() {
        return ResponseEntity.ok(facturaService.listarFacturas());
    }

    @PatchMapping("/{id_factura}/estado")
    public ResponseEntity<FacturaDTO> cambiarEstado(
            @PathVariable Integer id_factura,
            @RequestParam Estado estado) {
        FacturaDTO factura = facturaService.cambiarEstado(id_factura, estado);
        return ResponseEntity.ok(factura);
    }
}
