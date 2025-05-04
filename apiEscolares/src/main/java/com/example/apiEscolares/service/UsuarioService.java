package com.example.apiEscolares.service;

import com.example.apiEscolares.dto.UsuarioRequest;
import com.example.apiEscolares.model.Rol;
import com.example.apiEscolares.model.Usuario;
import com.example.apiEscolares.repository.RolRepository;
import com.example.apiEscolares.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario createUsuario(UsuarioRequest usuarioRequest) {
        if (usuarioRepository.findByEmail(usuarioRequest.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }

        Rol rol = rolRepository.findById(usuarioRequest.getRolId())
                .orElseThrow(() -> new RuntimeException("Rol not found"));

        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioRequest.getNombre());
        usuario.setEmail(usuarioRequest.getEmail());
        usuario.setPassword(usuarioRequest.getPassword());
        usuario.setRol(rol);

        return usuarioRepository.save(usuario);
    }
}
