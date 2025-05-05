package com.example.apiEscolares.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apiEscolares.model.Prestamos;

public interface PrestamoRepository extends JpaRepository<Prestamos, Integer> {
    List<Prestamos> findByUsuarioId(Integer usuarioId); // Para que un alumno vea solo sus préstamos
}