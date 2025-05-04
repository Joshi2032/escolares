package com.example.apiEscolares.repository;

import com.example.apiEscolares.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Integer> {
    // Additional query methods if needed
}
