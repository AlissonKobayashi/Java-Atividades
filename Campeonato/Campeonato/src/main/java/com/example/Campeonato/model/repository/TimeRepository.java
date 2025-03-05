package com.example.Campeonato.model.repository;

import com.example.Campeonato.model.domain.ModelTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeRepository extends JpaRepository<ModelTime, Long> {
}
