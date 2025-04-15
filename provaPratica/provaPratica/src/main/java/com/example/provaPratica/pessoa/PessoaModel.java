package com.example.provaPratica.pessoa;


import com.example.provaPratica.trabalho.TrabalhoModel;
import com.example.provaPratica.trabalho.TrabalhoRepository;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "TBL_PESSOA")
public class PessoaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String cpf;
    @OneToMany
    @JoinColumn(name = "trabalho_id")
    private TrabalhoModel trabalho;

    public PessoaModel(){}

    public PessoaModel(Long id, String nome, String cpf, TrabalhoModel trabalho) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.trabalho = trabalho;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public TrabalhoModel getTrabalho() {
        return trabalho;
    }

    public void setTrabalho(TrabalhoModel trabalho) {
        this.trabalho = trabalho;
    }
}
