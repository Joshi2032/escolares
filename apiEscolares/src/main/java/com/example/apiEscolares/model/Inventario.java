package com.example.apiEscolares.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "inventario")
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "herramienta_id", referencedColumnName = "id", nullable = false)
    private Herramientas herramientas;

    @Column(name = "cantidad_agregada", nullable = false)
    private int cantidadAgregada;

    @Column(name = "fecha_ingreso", nullable = false)
    private LocalDate fechaIngreso;

    public Inventario() {}

    public Inventario(Integer id, Herramientas herramientas, int cantidadAgregada, LocalDate fechaIngreso) {
        this.id = id;
        this.herramientas = herramientas;
        this.cantidadAgregada = cantidadAgregada;
        this.fechaIngreso = fechaIngreso;
    }

    public Integer getId() {
        return id;
    }

    public Herramientas getHerramientas() {
        return herramientas;
    }

    public int getCantidadAgregada() {
        return cantidadAgregada;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public void setHerramientas(Herramientas herramientas) {
        this.herramientas = herramientas;
    }

    public void setCantidadAgregada(int cantidadAgregada) {
        this.cantidadAgregada = cantidadAgregada;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    
}