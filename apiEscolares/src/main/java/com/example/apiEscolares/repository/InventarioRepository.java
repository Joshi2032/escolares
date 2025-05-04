package com.example.apiEscolares.repository;

import com.example.apiEscolares.model.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventarioRepository extends JpaRepository<Inventario, Integer> {
    // Additional query methods if needed
}
