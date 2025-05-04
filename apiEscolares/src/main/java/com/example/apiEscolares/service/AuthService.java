package com.example.apiEscolares.service;

import com.example.apiEscolares.dto.LoginRequest;
import com.example.apiEscolares.model.Autenticacion;
import com.example.apiEscolares.model.Usuario;
import com.example.apiEscolares.repository.AutenticacionRepository;
import com.example.apiEscolares.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AutenticacionRepository autenticacionRepository;

    public String authenticate(LoginRequest loginRequest) {
        if (loginRequest == null || loginRequest.getEmail() == null || loginRequest.getPassword() == null) {
            throw new IllegalArgumentException("Email and password must not be null");
        }

        Optional<Usuario> usuario = usuarioRepository.findByEmail(loginRequest.getEmail());
        if (usuario.isPresent() && usuario.get().getPassword().equals(loginRequest.getPassword())) {
            String token = UUID.randomUUID().toString();
            Autenticacion autenticacion = new Autenticacion();
            autenticacion.setUsuario(usuario.get());
            autenticacion.setToken(token);
            autenticacionRepository.save(autenticacion);
            return token;
        }
        throw new IllegalArgumentException("Invalid email or password");
    }
}
