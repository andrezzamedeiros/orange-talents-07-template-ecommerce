package br.com.mercadoLivre.model.dto.request;

import br.com.mercadoLivre.model.OpiniaoUsuarioProduto;
import br.com.mercadoLivre.model.Produto;
import br.com.mercadoLivre.model.User;
import br.com.mercadoLivre.repositories.ProdutoRepository;
import br.com.mercadoLivre.repositories.UserRepository;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Optional;

public class OpiniaoUsuarioProdutoRequest {


    @NotNull
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

    public OpiniaoUsuarioProdutoRequest( @Size(min = 1, max = 5) Integer nota, @NotBlank String titulo, @NotBlank @Size(max = 500)String descricao) {
        this.nota = nota;
        this.titulo = titulo;
        this.descricao = descricao;
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

    public OpiniaoUsuarioProduto converter (EntityManager manager, User usuario, Produto produto){
        Assert.notNull(produto , "o produto com o id informado não foi encontrado");
        Assert.notNull(usuario , "usuário não existe");
        return new OpiniaoUsuarioProduto(nota, titulo, descricao, usuario, produto);
    }
}
