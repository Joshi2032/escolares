package com.example.apiEscolares.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
     @Column(nullable = false) // Define que no puede ser NULL
    private String nombre;

    @Column(nullable = false, unique = true) // Define que no puede ser NULL y debe ser único
    private String email;

    @Column(nullable = false) // Define que no puede ser NULL
    private String password;

    @ManyToOne
    @JoinColumn(name = "rol_id", referencedColumnName = "id", nullable = false)
    private Roles roles;


    public Usuario() {
        // Constructor vacío requerido por JPA
    }

    public Usuario(Integer id, String nombre, String email, String password, Roles roles) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.roles = roles;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Roles getroles() {
        return roles;
    }

    public void setroles(Roles roles) {
        this.roles = roles;
    }
}