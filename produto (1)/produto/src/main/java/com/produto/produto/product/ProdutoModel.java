package com.produto.produto.product;

import jakarta.persistence.*;

@Entity
@Table(name = "TBL_PRODUTO")
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double preco;
    private Integer quantEmEstoque;

    public ProdutoModel(){}

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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantEmEstoque() {
        return quantEmEstoque;
    }

    public void setQuantEmEstoque(Integer quantEmEstoque) {
        this.quantEmEstoque = quantEmEstoque;
    }
}
