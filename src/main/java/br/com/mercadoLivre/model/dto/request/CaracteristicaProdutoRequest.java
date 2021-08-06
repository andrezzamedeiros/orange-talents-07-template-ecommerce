package br.com.mercadoLivre.model.dto.request;

import br.com.mercadoLivre.model.CaracteristicaProduto;
import br.com.mercadoLivre.model.Produto;
import br.com.mercadoLivre.validations.annotations.UniqueValue;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CaracteristicaProdutoRequest {

    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;

    public CaracteristicaProdutoRequest(@NotBlank String nome, @NotBlank String descricao){
        this.nome = nome;
        this.descricao = descricao;
    }


    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public CaracteristicaProduto converter(Produto produto){
        return new CaracteristicaProduto(nome, descricao, produto);
    }
}
