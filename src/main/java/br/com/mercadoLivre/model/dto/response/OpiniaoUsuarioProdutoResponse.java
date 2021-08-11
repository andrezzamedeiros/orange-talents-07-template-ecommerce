package br.com.mercadoLivre.model.dto.response;

import br.com.mercadoLivre.model.OpiniaoUsuarioProduto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OpiniaoUsuarioProdutoResponse {

    private Integer nota;
    private String titulo;
    private String descricao;

    public OpiniaoUsuarioProdutoResponse(OpiniaoUsuarioProduto opiniaoUsuarioProduto){
        this.nota = opiniaoUsuarioProduto.getNota();
        this.titulo = opiniaoUsuarioProduto.getTitulo();
        this.descricao = opiniaoUsuarioProduto.getDescricao();
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
}
