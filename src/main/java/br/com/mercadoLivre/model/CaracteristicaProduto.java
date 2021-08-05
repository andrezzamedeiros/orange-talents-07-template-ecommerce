package br.com.mercadoLivre.model;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
public class CaracteristicaProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;

    @NotNull
    @ManyToOne
    private Produto produto;

    @Deprecated
    public CaracteristicaProduto() {
    }

    public CaracteristicaProduto(String nome, String descricao, Produto produto) {
        this.nome = nome;
        this.descricao = descricao;
        this.produto = produto;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Produto getProduto() {
        return produto;
    }

}
