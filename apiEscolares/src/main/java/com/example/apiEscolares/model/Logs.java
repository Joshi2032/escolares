package com.example.apiEscolares.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "logs")
public class Logs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String mensaje;

    @Column(name = "fecha_log", nullable = false)
    private LocalDateTime fechaLog;

    public Logs() {}

    public Logs(Integer id, String mensaje, LocalDateTime fechaLog) {
        this.id = id;
        this.mensaje = mensaje;
        this.fechaLog = fechaLog;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    public LocalDateTime getFechaLog() {
        return fechaLog;
    }
    public void setFechaLog(LocalDateTime fechaLog) {
        this.fechaLog = fechaLog;
    }
}
