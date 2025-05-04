package com.example.apiEscolares.service;

import com.example.apiEscolares.model.Notificacion;
import com.example.apiEscolares.repository.NotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificacionService {

    @Autowired
    private NotificacionRepository notificacionRepository;

    public List<Notificacion> getAllNotificaciones() {
        return notificacionRepository.findAll();
    }

    public Notificacion createNotificacion(Notificacion notificacion) {
        return notificacionRepository.save(notificacion);
    }

    public List<Notificacion> getNotificacionesByUsuarioId(Integer usuarioId) {
        return notificacionRepository.findByUsuarioId(usuarioId);
    }
}
