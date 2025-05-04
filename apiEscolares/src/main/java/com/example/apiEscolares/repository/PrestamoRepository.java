package com.example.apiEscolares.repository;

import com.example.apiEscolares.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {
    // Additional query methods if needed
}
