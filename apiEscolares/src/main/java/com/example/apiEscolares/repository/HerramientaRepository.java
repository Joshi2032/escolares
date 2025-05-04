package com.example.apiEscolares.repository;

import com.example.apiEscolares.model.Herramienta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HerramientaRepository extends JpaRepository<Herramienta, Integer> {
    // Additional query methods if needed
}
