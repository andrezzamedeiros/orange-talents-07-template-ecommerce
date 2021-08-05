package br.com.mercadoLivre.model.dto.response;

import br.com.mercadoLivre.model.Categoria;

public class CategoriaResponse {

    private String nome;

    public CategoriaResponse(Categoria categoria) {
        this.nome = categoria.getNome();
    }

    public String getNome() {
        return nome;
    }
}
