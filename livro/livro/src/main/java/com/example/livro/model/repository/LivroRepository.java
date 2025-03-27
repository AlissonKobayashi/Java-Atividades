package com.example.livro.model.repository;

import com.example.livro.enun.StatusLivro;
import com.example.livro.model.domain.ModelLivro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<ModelLivro, Long> {
    ModelLivro findByStatusLivro(StatusLivro statusLivro);
}
