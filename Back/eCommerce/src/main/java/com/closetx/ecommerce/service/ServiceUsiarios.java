package com.closetx.ecommerce.service;

import com.closetx.ecommerce.dtos.AltaUsuarioDTO;
import com.closetx.ecommerce.dtos.UsuarioDTO;
import com.closetx.ecommerce.entities.Usuario;
import com.closetx.ecommerce.entities.enums.Rol;
import com.closetx.ecommerce.repository.UsuarioRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceUsiarios {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> listarUsuarios() {
        List <Usuario> u = usuarioRepository.findAll();
        return modelMapper.map(u, new TypeToken<List<UsuarioDTO>>(){}.getType());
    }

    public UsuarioDTO buscarUsuarioPorId(Integer id) {
       Optional<Usuario> u = usuarioRepository.findById(id);
        if (u.isPresent()) {
            return modelMapper.map(u.get(), UsuarioDTO.class);
        }
        else {
            throw new EntityNotFoundException("Usuario no encontrado por id" + id);
        }
    }

    @Transactional
    public UsuarioDTO crearUsuario(AltaUsuarioDTO userDto){
        if (usuarioRepository.findByDni(userDto.getDni())){
            throw new EntityExistsException("Usuario ya existente");
        }
        Usuario usuario = modelMapper.map(userDto, Usuario.class);
        usuario.setRol(Rol.Cliente);
        usuario.setFecha_Registro(LocalDate.now());
        Usuario saved = usuarioRepository.save(usuario);
        return modelMapper.map(saved, UsuarioDTO.class);
    }

    public UsuarioDTO editarUsuario(Integer id, UsuarioDTO userDto){
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado"));
        usuario.setNombre_Completo(userDto.getNombre_Completo());
        usuario.setEmail(userDto.getEmail());
        usuario.setContrasenia(userDto.getContrasenia());
        usuario.setPais(userDto.getPais());
        usuario.setProvincia(userDto.getProvincia());
        usuario.setDireccion(userDto.getDireccion());
        usuario.setNumero(userDto.getNumero());

        Usuario saved = usuarioRepository.save(usuario);
        return modelMapper.map(saved, UsuarioDTO.class);
    }

    public void eliminarUsuario(Integer id){
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado"));
        usuarioRepository.delete(usuario);

    }
}
