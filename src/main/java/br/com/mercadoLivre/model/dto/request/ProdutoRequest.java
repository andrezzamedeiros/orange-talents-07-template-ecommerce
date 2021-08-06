package br.com.mercadoLivre.model.dto.request;

import br.com.mercadoLivre.model.Categoria;
import br.com.mercadoLivre.model.Produto;
import br.com.mercadoLivre.model.User;
import br.com.mercadoLivre.repositories.CategoriaRepository;
import br.com.mercadoLivre.repositories.UserRepository;
import br.com.mercadoLivre.validations.annotations.ExistsId;
import org.hibernate.validator.constraints.Length;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProdutoRequest {

    @NotBlank
    @NotNull
    private String nome;
    @NotNull @Positive
    private Double valor;
    @NotNull @Positive
    private Integer quantidade;
    @Size(min = 3)
    private List<CaracteristicaProdutoRequest> caracteristicas = new ArrayList<>();
    @NotNull @NotBlank @Length(max = 1000)
    private String descricao;
    @NotNull @ExistsId(domainClass = Categoria.class, fieldName = "id")
    private Long idCategoria;


    public ProdutoRequest(String nome, Double valor, Integer quantidade, List<CaracteristicaProdutoRequest> caracteristicas, String descricao, Long idCategoria) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.caracteristicas = caracteristicas;
        this.descricao = descricao;
        this.idCategoria = idCategoria;
        this.caracteristicas.addAll(caracteristicas);
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


    public Produto converter(CategoriaRepository categoriaRepository, User usuarioLogado, UserRepository userRepository){
        Optional<Categoria> categoria = categoriaRepository.findById(idCategoria);
        User user = userRepository.getById(usuarioLogado.getId());
        Assert.isTrue(categoria != null , "id categoria não existe");
        Assert.isTrue(user != null , "usuário não está válido para realizar esta ação!");
        return new Produto(nome, valor, quantidade, descricao, categoria.get(), user);
    }
}
