package com.example.apiEscolares.repository;

import com.example.apiEscolares.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log, Integer> {
    // Additional query methods if needed
}
