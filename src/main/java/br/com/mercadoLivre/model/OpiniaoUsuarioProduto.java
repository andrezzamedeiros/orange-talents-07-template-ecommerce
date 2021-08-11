package br.com.mercadoLivre.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class OpiniaoUsuarioProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Min(value = 1)
    @Max(value = 5)
    private Integer nota;
    @NotNull
    @NotBlank
    private String titulo;
    @NotNull
    @NotBlank
    @Size(max = 500)
    private String descricao;
    @NotNull
    @ManyToOne
    private User usuario;
    @NotNull
    @ManyToOne
    private Produto produto;

    public OpiniaoUsuarioProduto(Integer nota, String titulo, String descricao, User usuario, Produto produto) {
        this.nota = nota;
        this.titulo = titulo;
        this.descricao = descricao;
        this.usuario = usuario;
        this.produto = produto;
    }

    public Long getId() {
        return id;
    }

    public Integer getNota() {
        return nota;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public User getUsuario() {
        return usuario;
    }

    public Produto getProduto() {
        return produto;
    }

}
