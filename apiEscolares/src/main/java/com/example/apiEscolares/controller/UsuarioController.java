package com.example.apiEscolares.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.apiEscolares.model.Usuario;
import com.example.apiEscolares.model.Roles;
import com.example.apiEscolares.repository.UsuarioRepository;
import com.example.apiEscolares.repository.RolesRepository;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioRepository.save(usuario);
        return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
    }

    // Nuevo endpoint para actualizar el rol de un usuario
    @PutMapping("/{id}/rol")
    public ResponseEntity<?> actualizarRolUsuario(@PathVariable Integer id, @RequestBody Map<String, String> request) {
        String nuevoRolNombre = request.get("rol"); // ej: "admin"

        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
        if (usuarioOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }

        Optional<Roles> rolOpt = rolesRepository.findByNombre(nuevoRolNombre);
        if (rolOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Rol no válido: " + nuevoRolNombre);
        }

        Usuario usuario = usuarioOpt.get();
        usuario.setroles(rolOpt.get());
        usuarioRepository.save(usuario);

        return ResponseEntity.ok("Rol actualizado a: " + nuevoRolNombre);
    }
}
