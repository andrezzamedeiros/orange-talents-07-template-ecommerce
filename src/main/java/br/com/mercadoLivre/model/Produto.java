package br.com.mercadoLivre.model;

import br.com.mercadoLivre.model.dto.request.CaracteristicaProdutoRequest;

import javax.persistence.*;
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
    @NotNull @Min(value = 1)
    private Double valor;
    @NotNull @Min(value = 1)
    private Integer quantidade;
//    private List<CaracteristicaProduto> caracteristicas = new ArrayList<>();
    @NotNull @NotBlank
    private String descricao;
    @NotNull @ManyToOne
    private Categoria categoria;
    private LocalDateTime dataCadastro;

    public Produto(String nome, Double valor, Integer quantidade, String descricao, Categoria categoria, LocalDateTime dataCadastro) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.categoria = categoria;
        this.dataCadastro = LocalDateTime.now();
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

//    public List<CaracteristicaProduto> getCaracteristicas() {
//        return caracteristicas;
//    }

    public String getDescricao() {
        return descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }
}
