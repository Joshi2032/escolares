package com.example.apiEscolares.service;

import com.example.apiEscolares.model.Herramienta;
import com.example.apiEscolares.repository.HerramientaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HerramientaService {

    @Autowired
    private HerramientaRepository herramientaRepository;

    public List<Herramienta> getAllHerramientas() {
        return herramientaRepository.findAll();
    }

    public Herramienta createHerramienta(Herramienta herramienta) {
        return herramientaRepository.save(herramienta);
    }

    public List<Herramienta> getHerramientasWithStockGreaterThan(Integer stock) {
        return herramientaRepository.findByStockGreaterThan(stock);
    }
}
