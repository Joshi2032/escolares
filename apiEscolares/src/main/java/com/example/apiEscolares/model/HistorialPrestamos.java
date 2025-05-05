package com.example.apiEscolares.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "historial_prestamos")
public class HistorialPrestamos {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "prestamo_id", referencedColumnName = "id", nullable = false)
    private Prestamos prestamo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Accion accion;

     @Column(name = "fecha_accion", nullable = false)
    private LocalDateTime fechaAccion;

    public enum Accion {
        PRESTAMO, DEVOLUCION, ADVERTENCIA
    }

    public HistorialPrestamos() {}

    public HistorialPrestamos(Integer id, Prestamos prestamo, Accion accion, LocalDateTime fechaAccion) {
        this.id = id;
        this.prestamo = prestamo;
        this.accion = accion;
        this.fechaAccion = fechaAccion;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Prestamos getPrestamo() {
        return prestamo;
    }
    public void setPrestamo(Prestamos prestamo) {
        this.prestamo = prestamo;
    }
    public Accion getAccion() {
        return accion;
    }
    public void setAccion(Accion accion) {
        this.accion = accion;
    }
    public LocalDateTime getFechaAccion() {
        return fechaAccion;
    }
    public void setFechaAccion(LocalDateTime fechaAccion) {
        this.fechaAccion = fechaAccion;
        
    }
    
}
