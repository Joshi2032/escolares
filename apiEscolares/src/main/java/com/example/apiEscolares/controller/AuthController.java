package com.example.apiEscolares.controller;

import com.example.apiEscolares.dto.LoginRequest;
import com.example.apiEscolares.service.AuthService;
import jakarta.validation.Valid; // Corrected import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(authService.authenticate(loginRequest));
    }

    // Additional endpoints if needed
}
