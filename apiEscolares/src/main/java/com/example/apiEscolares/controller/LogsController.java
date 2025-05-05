package com.example.apiEscolares.controller;

import java.time.LocalDateTime;
import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiEscolares.model.Logs;
import com.example.apiEscolares.repository.LogRepository;

@RestController
@RequestMapping("/api/logs")
public class LogsController {
@Autowired
    private LogRepository logRepository;

    // Obtener todos los logs
    @GetMapping
    public List<Logs> getAllLogs() {
        return logRepository.findAll();
    }

    // Obtener log por ID
    @GetMapping("/{id}")
    public ResponseEntity<Logs> getLogById(@PathVariable Integer id) {
        Optional<Logs> log = logRepository.findById(id);
        return log.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear nuevo log
    @PostMapping
    public ResponseEntity<Logs> createLog(@RequestBody Logs log) {
        log.setFechaLog(LocalDateTime.now());
        Logs nuevoLog = logRepository.save(log);
        return new ResponseEntity<>(nuevoLog, HttpStatus.CREATED);
    }

    // Borrar log por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLog(@PathVariable Integer id) {
        if (!logRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        logRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
