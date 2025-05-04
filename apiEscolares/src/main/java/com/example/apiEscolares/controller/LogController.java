package com.example.apiEscolares.controller;

import com.example.apiEscolares.model.Log;
import com.example.apiEscolares.service.LogService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping
    public ResponseEntity<List<Log>> getAllLogs() {
        return ResponseEntity.ok(logService.getAllLogs());
    }

    @PostMapping
    public ResponseEntity<Log> createLog(@Valid @RequestBody Log log) {
        return ResponseEntity.ok(logService.createLog(log));
    }
}
