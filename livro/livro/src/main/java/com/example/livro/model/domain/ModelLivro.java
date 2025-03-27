package com.example.livro.model.domain;

import com.example.livro.enun.StatusLivro;
import jakarta.persistence.*;
import org.springframework.boot.Banner;

@Entity
public class ModelLivro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String autor;
    private String titulo;

    @Enumerated(EnumType.STRING)
    private StatusLivro statusLivro;

    public ModelLivro(){}

    public ModelLivro(Long id, String autor, String titulo, StatusLivro statusLivro) {
        this.id = id;
        this.autor = autor;
        this.titulo = titulo;
        this.statusLivro = statusLivro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public StatusLivro getStatusLivro() {
        return statusLivro;
    }

    public void setStatusLivro(StatusLivro statusLivro) {
        this.statusLivro = statusLivro;
    }
}
