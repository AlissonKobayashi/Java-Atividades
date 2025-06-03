package com.example.provaPraticaEliel;

import jakarta.persistence.*;

@Entity
@Table(name = "TBL_TAREFA")
public class ModelTarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private EnumTarefa status;

    public ModelTarefa(){}

    public ModelTarefa(Long id, String titulo, String descricao, EnumTarefa status) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
    }

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public EnumTarefa getStatus() {
        return status;
    }

    public void setStatus(EnumTarefa status) {
        this.status = status;
    }
}
