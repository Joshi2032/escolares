package com.example.apiEscolares.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "historial_prestamos")
public class HistorialPrestamo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "prestamo_id", nullable = false)
    private Prestamo prestamo;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AccionPrestamo accion;

    @Column(name = "fecha_accion", nullable = false)
    private LocalDateTime fechaAccion;

    public enum AccionPrestamo {
        PRESTAMO("prestamo"),
        DEVOLUCION("devolución"),
        ADVERTENCIA("advertencia");

        private final String value;

        AccionPrestamo(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public AccionPrestamo getAccion() {
        return accion;
    }

    public void setAccion(AccionPrestamo accion) {
        this.accion = accion;
    }

    public LocalDateTime getFechaAccion() {
        return fechaAccion;
    }

    public void setFechaAccion(LocalDateTime fechaAccion) {
        this.fechaAccion = fechaAccion;
    }
}