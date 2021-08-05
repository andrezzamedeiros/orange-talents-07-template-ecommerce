package br.com.mercadoLivre.model.dto.response;

import br.com.mercadoLivre.model.CaracteristicaProduto;
import br.com.mercadoLivre.model.Categoria;
import br.com.mercadoLivre.model.Produto;
import br.com.mercadoLivre.repositories.CaracteristicaProdutoRepository;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ProdutoResponse {

    private String nome;
    private Double valor;
    private Integer quantidade;
    private String descricao;
    private String categoria;
    private LocalDateTime dataCadastro;
    private Set<CaracteristicaProdutoResponse> caracteristicas;

    public ProdutoResponse(List<CaracteristicaProduto> caracteristicaProdutos, Produto produto) {
        this.nome = produto.getNome();
        this.valor = produto.getValor();
        this.quantidade = produto.getQuantidade();
        this.descricao = produto.getDescricao();
        this.categoria = produto.getCategoria().getNome();
        this.dataCadastro = produto.getDataCadastro();
        this.caracteristicas = caracteristicaProdutos.stream().map(CaracteristicaProdutoResponse::new).collect(Collectors.toSet());
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

    public String getCategoria() {
        return categoria;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public Set<CaracteristicaProdutoResponse> getCaracteristicas() {
        return caracteristicas;
    }
}
