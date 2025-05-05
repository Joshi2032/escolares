package com.example.apiEscolares.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiEscolares.model.Roles;
import com.example.apiEscolares.repository.RolesRepository;

@RestController
@RequestMapping("/api/roles")
public class RolesController {

    @Autowired
    private RolesRepository rolesRepository;

    @GetMapping
    public List<Roles> getAllRoles() {
        return rolesRepository.findAll();
    }
}
