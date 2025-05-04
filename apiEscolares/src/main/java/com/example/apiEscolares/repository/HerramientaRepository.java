package com.example.apiEscolares.repository;

import com.example.apiEscolares.model.Herramienta;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HerramientaRepository extends JpaRepository<Herramienta, Integer> {
    // Additional query methods if needed
    List<Herramienta> findByStockGreaterThan(Integer stock);
}
