package com.example.apiEscolares.repository;

import com.example.apiEscolares.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RolRepository extends JpaRepository<Rol, Integer> {
    // Additional query methods if needed
    Optional<Rol> findByNombre(String nombre);
}
