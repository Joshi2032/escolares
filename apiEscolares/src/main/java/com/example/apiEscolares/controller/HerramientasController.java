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

import com.example.apiEscolares.model.Herramientas;
import com.example.apiEscolares.repository.HerramientasRepository;

@RestController
@RequestMapping("/api/herramientas")
public class HerramientasController {
    @Autowired
    private HerramientasRepository herramientasRepository;

    // 🟢 Todos los usuarios pueden ver herramientas
    @GetMapping
    public List<Herramientas> getAllHerramientas() {
        return herramientasRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Herramientas> getHerramientaById(@PathVariable Integer id) {
        Optional<Herramientas> herramienta = herramientasRepository.findById(id);
        return herramienta.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 🔒 Acceso solo para administradores (asumido que hay filtro o validación aparte)
    @PostMapping
    public ResponseEntity<Herramientas> createHerramienta(@RequestBody Herramientas herramienta) {
        return ResponseEntity.ok(herramientasRepository.save(herramienta));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Herramientas> updateHerramienta(@PathVariable Integer id, @RequestBody Herramientas updatedData) {
        Optional<Herramientas> herramientaOpt = herramientasRepository.findById(id);
        if (herramientaOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Herramientas herramienta = herramientaOpt.get();
        herramienta.setNombre(updatedData.getNombre());
        herramienta.setDescripcion(updatedData.getDescripcion());
        herramienta.setStock(updatedData.getStock());
        herramienta.setImagenURL(updatedData.getImagenURL());
        herramienta.setFechaAgregado(updatedData.getFechaAgregado());

        return ResponseEntity.ok(herramientasRepository.save(herramienta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHerramienta(@PathVariable Integer id) {
        if (!herramientasRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        herramientasRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
