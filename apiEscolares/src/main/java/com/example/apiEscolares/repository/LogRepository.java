package com.example.apiEscolares.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apiEscolares.model.Logs;

public interface LogRepository extends JpaRepository<Logs, Integer> {
    
}