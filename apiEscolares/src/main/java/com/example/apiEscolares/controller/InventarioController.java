package com.example.apiEscolares.controller;

import com.example.apiEscolares.model.Inventario;
import com.example.apiEscolares.service.InventarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventarios")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @GetMapping
    public ResponseEntity<List<Inventario>> getAllInventarios() {
        return ResponseEntity.ok(inventarioService.getAllInventarios());
    }

    @PostMapping
    public ResponseEntity<Inventario> createInventario(@Valid @RequestBody Inventario inventario) {
        return ResponseEntity.ok(inventarioService.createInventario(inventario));
    }

    @GetMapping("/herramienta/{herramientaId}")
    public ResponseEntity<List<Inventario>> getInventariosByHerramientaId(@PathVariable Integer herramientaId) {
        return ResponseEntity.ok(inventarioService.getInventariosByHerramientaId(herramientaId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inventario> updateInventario(@PathVariable Integer id, @Valid @RequestBody Inventario inventario) {
        inventario.setId(id);
        return ResponseEntity.ok(inventarioService.updateInventario(inventario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInventario(@PathVariable Integer id) {
        inventarioService.deleteInventario(id);
        return ResponseEntity.noContent().build();
    }
}
