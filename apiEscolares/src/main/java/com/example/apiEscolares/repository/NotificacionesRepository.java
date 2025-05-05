package com.example.apiEscolares.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apiEscolares.model.Notificaciones;

public interface NotificacionesRepository extends JpaRepository<Notificaciones, Integer> {
    List<Notificaciones> findByUsuarioId(Integer usuarioId); // Ver notificaciones por usuario
}