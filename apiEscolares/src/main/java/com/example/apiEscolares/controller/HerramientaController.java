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

    // Additional endpoints if needed
}
