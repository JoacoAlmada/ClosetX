package com.closetx.ecommerce.service;

import com.closetx.ecommerce.dtos.Detalle_FacturaDTO;
import com.closetx.ecommerce.entities.Detalle_Factura;
import com.closetx.ecommerce.entities.Factura;
import com.closetx.ecommerce.entities.Producto;
import com.closetx.ecommerce.repository.DetalleFacturaRepository;
import com.closetx.ecommerce.repository.FacturaRepository;
import com.closetx.ecommerce.repository.ProductoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleFacturaService {
    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;
    @Autowired
    private FacturaRepository facturaRepository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private ModelMapper modelMapper;

    public Detalle_FacturaDTO agregarDetalle(Integer id_factura, Detalle_FacturaDTO detalleDTO) {
        Factura factura = facturaRepository.findById(id_factura)
                .orElseThrow(() -> new RuntimeException("Factura no encontrada"));

        Producto producto = productoRepository.findById(detalleDTO.getProducto().getId_producto())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        if (producto.getStock() < detalleDTO.getCantidad()) {
            throw new RuntimeException("Stock insuficiente");
        }

        producto.setStock(producto.getStock() - detalleDTO.getCantidad());

        Detalle_Factura detalle = new Detalle_Factura();
        detalle.setFactura(factura);
        detalle.setProducto(producto);
        detalle.setCantidad(detalleDTO.getCantidad());
        detalle.setPrecio_Unitario(producto.getPrecio());
        detalle.setSubTotal(producto.getPrecio() * detalleDTO.getCantidad());

        Detalle_Factura guardado = detalleFacturaRepository.save(detalle);

        factura.setTotal(factura.getTotal() + guardado.getSubTotal());
        facturaRepository.save(factura);

        return modelMapper.map(guardado, Detalle_FacturaDTO.class);
    }

    public List<Detalle_FacturaDTO> listarDetalles(Integer id_factura) {
        return detalleFacturaRepository.findByFacturaId(id_factura)
                .stream()
                .map(d -> modelMapper.map(d, Detalle_FacturaDTO.class))
                .toList();
    }
}
