package com.example.apiEscolares.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiEscolares.model.Inventario;
import com.example.apiEscolares.repository.InventarioRepository;

@RestController
@RequestMapping("/api/inventario")
public class InventarioController {
@Autowired
    private InventarioRepository inventarioRepository;

    // 🔓 Admin: Ver todo el inventario
    @GetMapping
    public List<Inventario> getAllInventario() {
        return inventarioRepository.findAll();
    }

    // 🔒 Usuario: Ver inventario de herramientas (solo ver el inventario, no modificar)
    @GetMapping("/herramienta/{herramientaId}")
    public ResponseEntity<Inventario> getInventarioByHerramienta(@PathVariable Integer herramientaId) {
        return inventarioRepository.findById(herramientaId)
            .map(inventario -> ResponseEntity.ok(inventario))
            .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // 🔓 Admin: Crear una nueva entrada en el inventario (cuando se agrega nueva herramienta o stock)
    @PostMapping
    public ResponseEntity<Inventario> agregarInventario(@RequestBody Inventario inventario) {
        Inventario nuevoInventario = inventarioRepository.save(inventario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoInventario);
    }

    // 🔓 Admin: Actualizar cantidad de herramientas en el inventario
    @PutMapping("/{id}")
    public ResponseEntity<Inventario> actualizarInventario(@PathVariable Integer id, @RequestBody Inventario inventario) {
        return inventarioRepository.findById(id)
            .map(existingInventario -> {
                existingInventario.setCantidadAgregada(inventario.getCantidadAgregada());
                Inventario updatedInventario = inventarioRepository.save(existingInventario);
                return ResponseEntity.ok(updatedInventario);
            })
            .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
