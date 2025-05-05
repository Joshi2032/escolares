package com.example.apiEscolares.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apiEscolares.model.Roles;

public interface RolesRepository extends JpaRepository<Roles, Integer>{
    Optional<Roles> findByNombre(String nombre);
}
