package com.example.apiEscolares.repository;

import com.example.apiEscolares.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {
    // Additional query methods if needed
    List<Prestamo> findByUsuarioId(Integer usuarioId);
    List<Prestamo> findByEstado(Prestamo.EstadoPrestamo estado);
}
