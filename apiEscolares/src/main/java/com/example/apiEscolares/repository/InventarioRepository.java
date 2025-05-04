package com.example.apiEscolares.repository;

import com.example.apiEscolares.model.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface InventarioRepository extends JpaRepository<Inventario, Integer> {
    // Additional query methods if needed
    List<Inventario> findByHerramientaId(Integer herramientaId);
}
