package com.example.apiEscolares.repository;

import com.example.apiEscolares.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface LogRepository extends JpaRepository<Log, Integer> {
    // Additional query methods if needed
    List<Log> findByFechaLogBetween(LocalDateTime startDate, LocalDateTime endDate);
}
