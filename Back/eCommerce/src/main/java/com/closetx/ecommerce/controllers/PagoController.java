package com.closetx.ecommerce.controllers;

import com.closetx.ecommerce.dtos.PagoDTO;
import com.closetx.ecommerce.service.PagoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pagos")
@RequiredArgsConstructor
public class PagoController {
    private final PagoService pagoService;

    @PostMapping
    public ResponseEntity<PagoDTO> registrarPago(@RequestBody PagoDTO pagoDTO) {
        return ResponseEntity.ok(pagoService.registrarPago(pagoDTO));
    }

    @PatchMapping("/{id_pago}/confirmar")
    public ResponseEntity<PagoDTO> confirmarPago(@PathVariable Integer id_pago) {
        return ResponseEntity.ok(pagoService.confirmarPago(id_pago));
    }

    @PatchMapping("/{id_pago}/rechazar")
    public ResponseEntity<PagoDTO> rechazarPago(@PathVariable Integer id_pago) {
        return ResponseEntity.ok(pagoService.rechazarPago(id_pago));
    }

    @GetMapping("/factura/{id_factura}")
    public ResponseEntity<List<PagoDTO>> pagosPorFactura(@PathVariable Integer id_factura) {
        return ResponseEntity.ok(pagoService.obtenerPagosPorFactura(id_factura));
    }
}
