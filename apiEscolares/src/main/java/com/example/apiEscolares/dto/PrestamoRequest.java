package com.example.apiEscolares.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class PrestamoRequest {

    @NotNull(message = "Usuario ID is required")
    private Integer usuarioId;

    @NotNull(message = "Herramienta ID is required")
    private Integer herramientaId;

    @NotNull(message = "Fecha de prestamo is required")
    private LocalDate fechaPrestamo;

    // Getters and setters
    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getHerramientaId() {
        return herramientaId;
    }

    public void setHerramientaId(Integer herramientaId) {
        this.herramientaId = herramientaId;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }
}
