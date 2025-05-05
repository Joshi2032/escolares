package com.example.apiEscolares.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apiEscolares.model.Inventario;

public interface InventarioRepository extends JpaRepository<Inventario, Integer> {
    // Puedes agregar más métodos si es necesario, por ejemplo, para obtener inventario de una herramienta específica
}