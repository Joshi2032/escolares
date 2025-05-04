package com.example.apiEscolares.controller;

import com.example.apiEscolares.model.Notificacion;
import com.example.apiEscolares.service.NotificacionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionController {

    @Autowired
    private NotificacionService notificacionService;

    @GetMapping
    public ResponseEntity<List<Notificacion>> getAllNotificaciones() {
        return ResponseEntity.ok(notificacionService.getAllNotificaciones());
    }

    @PostMapping
    public ResponseEntity<Notificacion> createNotificacion(@Valid @RequestBody Notificacion notificacion) {
        return ResponseEntity.ok(notificacionService.createNotificacion(notificacion));
    }

    // Additional endpoints if needed
}
