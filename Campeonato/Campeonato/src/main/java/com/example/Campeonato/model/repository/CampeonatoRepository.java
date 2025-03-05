package com.example.Campeonato.model.repository;

import com.example.Campeonato.model.domain.ModelCampeonato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampeonatoRepository extends JpaRepository<ModelCampeonato, Long> {
}
