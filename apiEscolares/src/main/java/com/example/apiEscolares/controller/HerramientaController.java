package com.example.apiEscolares.controller;

import com.example.apiEscolares.model.Herramienta;
import com.example.apiEscolares.service.HerramientaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/herramientas")
public class HerramientaController {

    @Autowired
    private HerramientaService herramientaService;

    @GetMapping
    public ResponseEntity<List<Herramienta>> getAllHerramientas() {
        return ResponseEntity.ok(herramientaService.getAllHerramientas());
    }

    @PostMapping
    public ResponseEntity<Herramienta> createHerramienta(@Valid @RequestBody Herramienta herramienta) {
        return ResponseEntity.ok(herramientaService.createHerramienta(herramienta));
    }

    @GetMapping("/stock")
    public ResponseEntity<List<Herramienta>> getHerramientasWithStockGreaterThan(@RequestParam("stock") Integer stock) {
        return ResponseEntity.ok(herramientaService.getHerramientasWithStockGreaterThan(stock));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Herramienta> updateHerramienta(@PathVariable Integer id, @Valid @RequestBody Herramienta herramienta) {
        herramienta.setId(id);
        return ResponseEntity.ok(herramientaService.updateHerramienta(herramienta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHerramienta(@PathVariable Integer id) {
        herramientaService.deleteHerramienta(id);
        return ResponseEntity.noContent().build();
    }

    // Additional endpoints if needed
}
