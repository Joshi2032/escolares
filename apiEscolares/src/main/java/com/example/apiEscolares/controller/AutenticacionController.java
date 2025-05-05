package com.example.apiEscolares.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiEscolares.model.Autenticacion;
import com.example.apiEscolares.model.Usuario;
import com.example.apiEscolares.repository.AutenticacionRepository;
import com.example.apiEscolares.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/autenticacion")

public class AutenticacionController {
    @Autowired
    private AutenticacionRepository autenticacionRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    // 🔐 Login
    @PostMapping("/login")
    public ResponseEntity<String> loginUsuario(@RequestParam String email, @RequestParam String password) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmailAndPassword(email, password);

        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            String token = generateToken(usuario);

            Autenticacion autenticacion = new Autenticacion();
            autenticacion.setUsuario(usuario);
            autenticacion.setToken(token);
            autenticacionRepository.save(autenticacion);

            return ResponseEntity.ok("Token generado: " + token);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }

    // ✅ Verificar token
    @GetMapping("/verificar/{token}")
    public ResponseEntity<String> verificarToken(@PathVariable String token) {
        Optional<Autenticacion> autenticacion = autenticacionRepository.findByToken(token);

        if (autenticacion.isPresent()) {
            return ResponseEntity.ok("Token válido");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token no válido");
        }
    }

    @GetMapping
    public ResponseEntity<String> getAutenticacionInfo() {
        return ResponseEntity.ok("Endpoint de autenticación activo");
    }

    // 🔧 Generador de token básico
    private String generateToken(Usuario usuario) {
        return "token_" + usuario.getId() + "_" + System.currentTimeMillis();
    }
}
