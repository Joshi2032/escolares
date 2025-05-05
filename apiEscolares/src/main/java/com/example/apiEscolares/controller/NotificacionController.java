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

import com.example.apiEscolares.model.Notificaciones;
import com.example.apiEscolares.repository.NotificacionesRepository;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionController {
    @Autowired
    private NotificacionesRepository notificacionesRepository;

    // 🔓 Admin: Ver todas las notificaciones
    @GetMapping
    public List<Notificaciones> getAllNotificaciones() {
        return notificacionesRepository.findAll();
    }

    // 🔒 Usuario: Ver solo sus notificaciones (por ID de usuario)
    @GetMapping("/usuario/{usuarioId}")
    public List<Notificaciones> getNotificacionesByUsuario(@PathVariable Integer usuarioId) {
        return notificacionesRepository.findByUsuarioId(usuarioId);
    }

    // 🔓 Admin: Crear nueva notificación (ej. cuando se envía una notificación)
    @PostMapping
    public ResponseEntity<Notificaciones> crearNotificacion(@RequestBody Notificaciones notificacion) {
        Notificaciones nuevaNotificacion = notificacionesRepository.save(notificacion);
        return ResponseEntity.ok(nuevaNotificacion);
    }
}
