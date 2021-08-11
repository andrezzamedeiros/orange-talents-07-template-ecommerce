package br.com.mercadoLivre.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class PerguntaUsuarioProduto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotBlank
    private String titulo;
    private LocalDateTime instante = LocalDateTime.now();
    @NotNull
    @ManyToOne
    private User usuario;
    @NotNull
    @ManyToOne
    private Produto produto;

    public PerguntaUsuarioProduto(String titulo, User usuario, Produto produto) {
        this.titulo = titulo;
        this.usuario = usuario;
        this.produto = produto;
    }

    @Deprecated
    public PerguntaUsuarioProduto(){

    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDateTime getInstante() {
        return instante;
    }

    public User getUsuario() {
        return usuario;
    }

    public Produto getProduto() {
        return produto;
    }

    @Override
    public String toString() {
        return "PerguntaUsuarioProduto {" +
                "titulo='" + titulo + '\'' +
                ", instante=" + instante +
                ", produto=" + produto +
                '}';
    }
}
