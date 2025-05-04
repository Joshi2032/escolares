package com.example.apiEscolares.repository;

import com.example.apiEscolares.model.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificacionRepository extends JpaRepository<Notificacion, Integer> {
    // Additional query methods if needed
}
