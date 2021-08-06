package br.com.mercadoLivre.model;

import br.com.mercadoLivre.model.dto.request.CaracteristicaProdutoRequest;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank @NotNull
    private String nome;
    @NotNull @Positive
    private Double valor;
    @NotNull @Positive
    private Integer quantidade;
    @NotNull @NotBlank @Length(max = 1000)
    private String descricao;
    @NotNull @ManyToOne
    private Categoria categoria;
    private LocalDateTime dataCadastro = LocalDateTime.now();

    @NotNull @Valid @ManyToOne
    private User usuario;

    public Produto() {
    }

    public Produto(@NotBlank String nome, @Positive Double valor, @Positive Integer quantidade, @NotBlank @Length(max = 1000)
            String descricao, @NotNull@Valid Categoria categoria ,User usuario) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.categoria = categoria;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getValor() {
        return valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public User getUsuario() {
        return usuario;
    }
}
