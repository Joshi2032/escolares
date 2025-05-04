package com.example.apiEscolares;

import com.example.apiEscolares.model.*;
import com.example.apiEscolares.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class ApiEscolaresApplication implements CommandLineRunner {

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private HerramientaRepository herramientaRepository;

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private NotificacionRepository notificacionRepository;

    public static void main(String[] args) {
        SpringApplication.run(ApiEscolaresApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Add roles
        Rol adminRole = new Rol();
        adminRole.setNombre("admin");
        rolRepository.save(adminRole);

        Rol userRole = new Rol();
        userRole.setNombre("user");
        rolRepository.save(userRole);

        // Add users
        Usuario admin = new Usuario();
        admin.setNombre("Admin User");
        admin.setEmail("admin@example.com");
        admin.setPassword("admin123");
        admin.setRol(adminRole);
        usuarioRepository.save(admin);

        Usuario user = new Usuario();
        user.setNombre("Regular User");
        user.setEmail("user@example.com");
        user.setPassword("user123");
        user.setRol(userRole);
        usuarioRepository.save(user);

        // Add herramientas
        Herramienta hammer = new Herramienta();
        hammer.setNombre("Hammer");
        hammer.setDescripcion("A tool for hammering nails");
        hammer.setStock(10);
        hammer.setImagenURL("http://example.com/hammer.jpg");
        hammer.setFechaAgregado(LocalDate.now());
        herramientaRepository.save(hammer);

        // Add prestamos
        Prestamo prestamo = new Prestamo();
        prestamo.setUsuario(user);
        prestamo.setHerramienta(hammer);
        prestamo.setFechaPrestamo(LocalDate.now());
        prestamo.setEstado(Prestamo.EstadoPrestamo.PENDIENTE);
        prestamoRepository.save(prestamo);

        // Add notificaciones
        Notificacion notificacion = new Notificacion();
        notificacion.setUsuario(user);
        notificacion.setMensaje("Your loan is due soon.");
        notificacion.setFechaNotificacion(LocalDateTime.now());
        notificacionRepository.save(notificacion);
    }
}
