package com.example.gerenciarFuncionarios.model.repository;

import com.example.gerenciarFuncionarios.model.domain.ModelFuncionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryFuncionario extends JpaRepository<ModelFuncionario, Long> {
}
