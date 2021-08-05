package br.com.mercadoLivre.model.dto.response;

import br.com.mercadoLivre.model.CaracteristicaProduto;

import javax.validation.constraints.NotBlank;

public class CaracteristicaProdutoResponse {

    private String nome;
    private String descricao;

    public CaracteristicaProdutoResponse(CaracteristicaProduto caracteristicaProduto){
        this.nome = caracteristicaProduto.getNome();
        this.descricao = caracteristicaProduto.getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
