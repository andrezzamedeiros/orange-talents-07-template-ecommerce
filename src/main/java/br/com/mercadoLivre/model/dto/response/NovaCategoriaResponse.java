package br.com.mercadoLivre.model.dto.response;

import br.com.mercadoLivre.model.Categoria;

public class NovaCategoriaResponse {

    private String nome;

    public NovaCategoriaResponse(Categoria categoria) {
        this.nome = categoria.getNome();
    }

    public String getNome() {
        return nome;
    }
}
