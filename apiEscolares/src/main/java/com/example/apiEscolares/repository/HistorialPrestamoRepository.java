package com.example.apiEscolares.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apiEscolares.model.HistorialPrestamos;

public interface HistorialPrestamoRepository extends JpaRepository<HistorialPrestamos, Integer> {
    List<HistorialPrestamos> findByPrestamo_Usuario_Id(Integer usuarioId); // Actualizar el nombre de la propiedad
    List<HistorialPrestamos> findByPrestamo_UsuarioId(Integer usuarioId); // Actualizar el nombre de la propiedad

}
