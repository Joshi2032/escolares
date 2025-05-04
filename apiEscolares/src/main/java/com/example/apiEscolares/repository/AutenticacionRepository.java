package com.example.apiEscolares.repository;

import com.example.apiEscolares.model.Autenticacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutenticacionRepository extends JpaRepository<Autenticacion, Integer> {
    Optional<Autenticacion> findByToken(String token);
}
