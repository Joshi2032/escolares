package com.example.apiEscolares.repository;

import com.example.apiEscolares.model.Autenticacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutenticacionRepository extends JpaRepository<Autenticacion, Integer> {
    // Additional query methods if needed
}
