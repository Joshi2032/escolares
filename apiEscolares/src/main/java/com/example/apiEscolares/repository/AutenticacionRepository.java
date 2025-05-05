package com.example.apiEscolares.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.apiEscolares.model.Autenticacion;

@Repository
public interface AutenticacionRepository extends JpaRepository<Autenticacion, Integer> {

    // Buscar autenticación por token
    Optional<Autenticacion> findByToken(String token);
}
