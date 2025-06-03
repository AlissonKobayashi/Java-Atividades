package com.example.provaPraticaEliel.usuario;

import jakarta.persistence.*;

@Entity
@Table(name = "TBL_USUARIO")
public class ModelUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String uername;
    private String senha;

    public ModelUsuario(){}

    public ModelUsuario(Long id, String uername, String senha) {
        this.id = id;
        this.uername = uername;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUername() {
        return uername;
    }

    public void setUername(String uername) {
        this.uername = uername;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
