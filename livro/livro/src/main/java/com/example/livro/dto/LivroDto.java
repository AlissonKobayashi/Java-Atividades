package com.example.livro.dto;

import com.example.livro.enun.StatusLivro;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class LivroDto {
    private Long id;
    private String titulo;
    private String autor;

    public LivroDto() {}

    @Enumerated(EnumType.STRING)
    private StatusLivro statusLivro;

    public LivroDto(Long id, String titulo, String autor, StatusLivro statusLivro) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.statusLivro = statusLivro;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public StatusLivro getStatusLivro() {
        return statusLivro;
    }

    public void setStatusLivro(StatusLivro statusLivro) {
        this.statusLivro = statusLivro;
    }
}
