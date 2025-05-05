package com.example.apiEscolares.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiEscolares.model.Usuario;
import com.example.apiEscolares.repository.UsuarioRepository;

@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario loginUsuario) {
        Usuario usuarioExistente = usuarioRepository.findByEmailAndPassword(loginUsuario.getEmail(), loginUsuario.getPassword()).orElse(null);
        if (usuarioExistente != null) {
            return ResponseEntity.ok().body("Inicio de sesión exitoso");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Correo o contraseña incorrectos");
        }
    }
}

