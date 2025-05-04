package com.example.apiEscolares.repository;

import com.example.apiEscolares.model.HistorialPrestamo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistorialPrestamoRepository extends JpaRepository<HistorialPrestamo, Integer> {
    // Additional query methods if needed
}
