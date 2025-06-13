package com.example.provaPraticaEliel.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositoryUsuario extends JpaRepository<ModelUsuario, Long> {


     Optional<ModelUsuario> findByLogin(String login);
}
