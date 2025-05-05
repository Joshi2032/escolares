package com.example.apiEscolares.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "herramientas")
public class Herramientas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false) // Define que no puede ser NULL
    private String nombre;

    @Column(columnDefinition = "TEXT") 
    private String descripcion;

    @Column(nullable = false) // Define que no puede ser NULL
    private Integer stock;

    @Temporal(TemporalType.DATE)
    private String imagenURL;

    @Column(name = "fecha_agregado", nullable = false)
    private LocalDateTime fechaAgregado;

    public Herramientas() {
        // Constructor vacío requerido por JPA
    }

    public Herramientas(Integer id, String nombre, String descripcion, Integer stock, String imagenURL,
            LocalDateTime fechaAgregado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.stock = stock;
        this.imagenURL = imagenURL;
        this.fechaAgregado = fechaAgregado;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getStock() {
        return stock;
    }
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    public String getImagenURL() {
        return imagenURL;
    }
    public void setImagenURL(String imagenURL) {
        this.imagenURL = imagenURL;
    }
    public LocalDateTime getFechaAgregado() {
        return fechaAgregado;
    }
    public void setFechaAgregado(LocalDateTime fechaAgregado) {
        this.fechaAgregado = fechaAgregado;
    }

}
