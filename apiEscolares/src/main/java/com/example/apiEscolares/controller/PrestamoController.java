package com.example.apiEscolares.controller;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiEscolares.model.Prestamos;
import com.example.apiEscolares.repository.PrestamoRepository;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {
    @Autowired
    private PrestamoRepository prestamoRepository;

    // 🔓 Admin: Ver todos los préstamos
    @GetMapping
    public List<Prestamos> getAllPrestamos() {
        return prestamoRepository.findAll();
    }

    // 🔒 Usuario: Ver solo sus préstamos (filtrados por ID de usuario)
    @GetMapping("/usuario/{usuarioId}")
    public List<Prestamos> getPrestamosByUsuario(@PathVariable Integer usuarioId) {
        return prestamoRepository.findByUsuarioId(usuarioId);
    }

    // 🔓 Usuario: Solicitar un préstamo
    @PostMapping
    public ResponseEntity<Prestamos> crearPrestamo(@RequestBody Prestamos prestamo) {
        Prestamos nuevoPrestamo = prestamoRepository.save(prestamo);
        return ResponseEntity.ok(nuevoPrestamo);
    }

    // 🔓 Admin: Actualizar estado del préstamo (ej. marcar como devuelto o atrasado)
    @PutMapping("/{id}")
    public ResponseEntity<Prestamos> actualizarPrestamo(@PathVariable Integer id, @RequestBody Prestamos prestamoData) {
        Optional<Prestamos> optionalPrestamo = prestamoRepository.findById(id);

        if (optionalPrestamo.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Prestamos prestamo = optionalPrestamo.get();
        prestamo.setFechaDevolucion(prestamoData.getFechaDevolucion());
        prestamo.setEstado(prestamoData.getEstado());

        return ResponseEntity.ok(prestamoRepository.save(prestamo));
    }

    // 🔓 Admin: Eliminar préstamo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPrestamo(@PathVariable Integer id) {
        if (!prestamoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        prestamoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
