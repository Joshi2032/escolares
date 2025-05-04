package com.example.apiEscolares.repository;

import com.example.apiEscolares.model.HistorialPrestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HistorialPrestamoRepository extends JpaRepository<HistorialPrestamo, Integer> {
    List<HistorialPrestamo> findByPrestamoId(Integer prestamoId);
}
