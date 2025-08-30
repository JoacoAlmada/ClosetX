package com.closetx.ecommerce.service;

import com.closetx.ecommerce.dtos.FacturaDTO;
import com.closetx.ecommerce.entities.Factura;
import com.closetx.ecommerce.entities.Usuario;
import com.closetx.ecommerce.entities.enums.Estado;
import com.closetx.ecommerce.repository.FacturaRepository;
import com.closetx.ecommerce.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FacturaService {
    @Autowired
    private FacturaRepository facturaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ModelMapper modelMapper;

    public FacturaDTO crearFactura(Integer id_usuario) {
        Usuario usuario = usuarioRepository.findById(id_usuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Factura factura = new Factura();
        factura.setUsuario(usuario);
        factura.setFecha(new Date());
        factura.setEstado(Estado.Pendiente);

        factura = facturaRepository.save(factura);
        return modelMapper.map(factura, FacturaDTO.class);
    }

    public FacturaDTO obtenerFactura(Integer id_factura) {
        Factura factura = facturaRepository.findById(id_factura)
                .orElseThrow(() -> new RuntimeException("Factura no encontrada"));
        return modelMapper.map(factura, FacturaDTO.class);
    }

    public List<FacturaDTO> listarFacturas() {
        return facturaRepository.findAll()
                .stream()
                .map(f -> modelMapper.map(f, FacturaDTO.class))
                .toList();
    }

    public FacturaDTO cambiarEstado(Integer id_factura, Estado nuevoEstado) {
        Factura factura = facturaRepository.findById(id_factura)
                .orElseThrow(() -> new RuntimeException("Factura no encontrada"));
        factura.setEstado(nuevoEstado);
        return modelMapper.map(facturaRepository.save(factura), FacturaDTO.class);
    }
}
