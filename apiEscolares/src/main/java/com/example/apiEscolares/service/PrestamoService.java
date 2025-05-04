package com.example.apiEscolares.service;

import com.example.apiEscolares.dto.PrestamoRequest;
import com.example.apiEscolares.model.Herramienta;
import com.example.apiEscolares.model.Prestamo;
import com.example.apiEscolares.model.Usuario;
import com.example.apiEscolares.repository.HerramientaRepository;
import com.example.apiEscolares.repository.PrestamoRepository;
import com.example.apiEscolares.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private HerramientaRepository herramientaRepository;

    public List<Prestamo> getAllPrestamos() {
        return prestamoRepository.findAll();
    }

    public Prestamo createPrestamo(PrestamoRequest prestamoRequest) {
        Usuario usuario = usuarioRepository.findById(prestamoRequest.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario not found"));
        Herramienta herramienta = herramientaRepository.findById(prestamoRequest.getHerramientaId())
                .orElseThrow(() -> new RuntimeException("Herramienta not found"));

        if (herramienta.getStock() <= 0) {
            throw new RuntimeException("Herramienta out of stock");
        }

        Prestamo prestamo = new Prestamo();
        prestamo.setUsuario(usuario);
        prestamo.setHerramienta(herramienta);
        prestamo.setFechaPrestamo(prestamoRequest.getFechaPrestamo());
        prestamo.setEstado(Prestamo.EstadoPrestamo.PENDIENTE);

        herramienta.setStock(herramienta.getStock() - 1);
        herramientaRepository.save(herramienta);

        return prestamoRepository.save(prestamo);
    }
}
