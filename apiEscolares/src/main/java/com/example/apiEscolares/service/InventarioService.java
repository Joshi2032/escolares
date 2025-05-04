package com.example.apiEscolares.service;

import com.example.apiEscolares.model.Inventario;
import com.example.apiEscolares.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioService {

    @Autowired
    private InventarioRepository inventarioRepository;

    public List<Inventario> getAllInventarios() {
        return inventarioRepository.findAll();
    }

    public Inventario createInventario(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }
}
