package com.example.apiEscolares;

import com.example.apiEscolares.model.*;
import com.example.apiEscolares.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private HerramientaRepository herramientaRepository;

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Test
    public void testFindByEmail() {
        Usuario usuario = usuarioRepository.findByEmail("admin@example.com").orElse(null);
        assertNotNull(usuario);
        assertEquals("Admin User", usuario.getNombre());
    }

    @Test
    public void testFindByStockGreaterThan() {
        List<Herramienta> herramientas = herramientaRepository.findByStockGreaterThan(5);
        assertFalse(herramientas.isEmpty());
        assertEquals("Hammer", herramientas.get(0).getNombre());
    }

    @Test
    public void testFindByEstado() {
        List<Prestamo> prestamos = prestamoRepository.findByEstado(Prestamo.EstadoPrestamo.PENDIENTE);
        assertFalse(prestamos.isEmpty());
        assertEquals("Hammer", prestamos.get(0).getHerramienta().getNombre());
    }
}
