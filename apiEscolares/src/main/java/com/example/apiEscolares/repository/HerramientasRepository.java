package com.example.apiEscolares.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apiEscolares.model.Herramientas;

public interface HerramientasRepository extends JpaRepository<Herramientas, Integer> {
    
}