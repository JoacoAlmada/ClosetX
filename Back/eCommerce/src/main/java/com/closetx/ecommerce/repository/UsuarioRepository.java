package com.closetx.ecommerce.repository;

import com.closetx.ecommerce.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    boolean findByDni(String dni);
}
