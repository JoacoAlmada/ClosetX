package com.closetx.ecommerce.service;

import com.closetx.ecommerce.dtos.ProductoDTO;
import com.closetx.ecommerce.entities.Producto;
import com.closetx.ecommerce.entities.Usuario;
import com.closetx.ecommerce.repository.ProductoRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<ProductoDTO> listarProductos() {
        List <Producto> p = productoRepository.findAll();
        return modelMapper.map(p, new TypeToken<List<ProductoDTO>>(){}.getType());
    }

    public ProductoDTO buscarProductoPorId(Integer id) {
        Optional<Producto> p = productoRepository.findById(id);
        if (p.isPresent()) {
            return modelMapper.map(p.get(), ProductoDTO.class);
        }
        else {
            throw new EntityNotFoundException("Producto no encontrado por id" + id);
        }
    }

    @Transactional
    public ProductoDTO crearProducto(ProductoDTO producDto){
        if (productoRepository.findByNombre((producDto.getNombre()))){
            throw new EntityExistsException("Producto ya existente");
        }
        Producto producto = modelMapper.map(producDto, Producto.class);
        Producto saved = productoRepository.save(producto);
        return modelMapper.map(saved, ProductoDTO.class);
    }

    public ProductoDTO editarProducto(Integer id, ProductoDTO userDto){
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));
        producto.setNombre(userDto.getNombre());
        producto.setDescripcion(userDto.getDescripcion());
        producto.setMarca(userDto.getMarca());
        producto.setCategoria(userDto.getCategoria());
        producto.setTalle(userDto.getTalle());
        producto.setStock(userDto.getStock());
        producto.setPrecio(userDto.getPrecio());
        producto.setImagen(userDto.getImagen());


        Producto saved = productoRepository.save(producto);
        return modelMapper.map(saved, ProductoDTO.class);
    }

    public void eliminarProducto(Integer id){
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));
        productoRepository.delete(producto);

    }
}
