package com.example.apiEscolares.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiEscolares.model.HistorialPrestamos;
import com.example.apiEscolares.repository.HistorialPrestamoRepository;

@RestController
@RequestMapping("/api/historialPrestamos")
public class HistorialPrestamoController {
    @Autowired
    private HistorialPrestamoRepository historialPrestamoRepository;

    // 🔓 Admin: Ver todos los historiales de préstamos
    @GetMapping
    public List<HistorialPrestamos> getAllHistoriales() {
        return historialPrestamoRepository.findAll();
    }

    // 🔒 Usuario: Ver el historial de un préstamo (por ID de préstamo)
    @GetMapping("/prestamo/{prestamoId}")
    public List<HistorialPrestamos> getHistorialByPrestamo(@PathVariable Integer prestamoId) {
        return historialPrestamoRepository.findByPrestamo_Usuario_Id(prestamoId);
    }

    // 🔓 Admin: Ver historial de un usuario (por ID de usuario)
    @GetMapping("/usuario/{usuarioId}")
    public List<HistorialPrestamos> getHistorialByUsuario(@PathVariable Integer usuarioId) {
        return historialPrestamoRepository.findByPrestamo_UsuarioId(usuarioId);
    }

    // 🔓 Admin: Crear nuevo historial de préstamo (ej. cuando se marca un préstamo como devuelto)
    @PostMapping
    public ResponseEntity<HistorialPrestamos> crearHistorialPrestamo(@RequestBody HistorialPrestamos historialPrestamo) {
        HistorialPrestamos nuevoHistorial = historialPrestamoRepository.save(historialPrestamo);
        return ResponseEntity.ok(nuevoHistorial);
    }
}
