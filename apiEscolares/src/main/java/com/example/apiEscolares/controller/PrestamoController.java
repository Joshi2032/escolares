package com.example.apiEscolares.controller;

import com.example.apiEscolares.dto.PrestamoRequest;
import com.example.apiEscolares.model.Prestamo;
import com.example.apiEscolares.service.PrestamoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    @GetMapping
    public ResponseEntity<List<Prestamo>> getAllPrestamos() {
        return ResponseEntity.ok(prestamoService.getAllPrestamos());
    }

    @PostMapping
    public ResponseEntity<Prestamo> createPrestamo(@Valid @RequestBody PrestamoRequest prestamoRequest) {
        return ResponseEntity.ok(prestamoService.createPrestamo(prestamoRequest));
    }

    // Additional endpoints if needed
}
