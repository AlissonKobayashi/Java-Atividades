package com.example.provaPratica.trabalho;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrabalhoRepository extends JpaRepository<TrabalhoModel, Long> {
    Optional<TrabalhoModel> findByNome(TrabalhoModel trabalho);
}
