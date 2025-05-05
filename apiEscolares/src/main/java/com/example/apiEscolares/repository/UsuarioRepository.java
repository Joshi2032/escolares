package com.example.apiEscolares.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import com.example.apiEscolares.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByEmailAndPassword(String email, String password);

}
