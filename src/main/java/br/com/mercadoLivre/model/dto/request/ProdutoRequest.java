package br.com.mercadoLivre.model.dto.request;

import br.com.mercadoLivre.model.Categoria;
import br.com.mercadoLivre.model.Produto;
import br.com.mercadoLivre.model.User;
import br.com.mercadoLivre.repositories.CategoriaRepository;
import br.com.mercadoLivre.validations.annotations.ExistsId;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class ProdutoRequest {

    @NotBlank
    @NotNull
    private String nome;
    @NotNull @Min(value = 1)
    private Double valor;
    @NotNull @Min(value = 1)
    private Integer quantidade;
    @Size(min = 3)
    private List<CaracteristicaProdutoRequest> caracteristicas;
    @NotNull @NotBlank
    private String descricao;
    @NotNull @ExistsId(domainClass = Categoria.class, fieldName = "id")
    private Long idCategoria;
    private LocalDateTime dataCadastro;

    public ProdutoRequest(String nome, Double valor, Integer quantidade, List<CaracteristicaProdutoRequest> caracteristicas, String descricao, Long idCategoria, LocalDateTime dataCadastro) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.caracteristicas = caracteristicas;
        this.descricao = descricao;
        this.idCategoria = idCategoria;
        this.dataCadastro = dataCadastro;
        this.caracteristicas = caracteristicas;
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

    public List<CaracteristicaProdutoRequest> getCaracteristicas() {
        return caracteristicas;
    }

    public String getDescricao() {
        return descricao;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public Produto converter(CategoriaRepository categoriaRepository){
        Optional<Categoria> categoria = categoriaRepository.findById(idCategoria);
        Assert.isTrue(categoria != null , "id categoria não existe");
        return new Produto(nome, valor, quantidade, descricao, categoria.get(), dataCadastro);
    }
}
